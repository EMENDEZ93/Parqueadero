package em.parqueadero.backend.domain.vehiculo.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.parqueadero.ParqueaderoJpaRepository;
import em.parqueadero.backend.repository.vehiculo.VehiculoJpaRepository;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;
	
	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException {
		vehiculoJpaRepository.count();
		parqueaderoJpaRepository.count();
		return null;
	}

	
	public VehiculoEntity ingresoVehiculoParqueaderoEntity(VehiculoEntity vehiculoEntity) {
		return vehiculoJpaRepository.save(vehiculoEntity);
	}
	
	public boolean placaIniciConA(Vehiculo vehiculo) {
		return String.valueOf(vehiculo.getPlaca()).startsWith("A");
	}

	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException {
		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES);
	}

	
	@Override
	public VehiculoEntity ingresoVehiculoParqueadero(Vehiculo vehiculo) throws PreconditionException {
		lugarDisponibleEnParqueadero(vehiculo);
		
		if(placaIniciConA(vehiculo)) {
			ingresoVehiculoSoloDomingoLunes();
			return vehiculoJpaRepository.save(VehiculoBuilder.convertToEntity(vehiculo));
		} else {
			return vehiculoJpaRepository.save(VehiculoBuilder.convertToEntity(vehiculo));
		}
	}


	@Override
	public boolean lugarDisponibleEnParqueadero(Vehiculo vehiculo) throws PreconditionException {		
		switch (vehiculo.getTipoVehiculo()) {
		case "Carro":
			return lugarDisponibleEnParqueaderoCarro();
		case "Moto":
			return lugarDisponibleEnParqueaderoMoto();
		default:
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE);
		}
	}

	public boolean lugarDisponibleEnParqueaderoMoto() throws PreconditionException {
		if(parqueaderoJpaRepository.findByTipoVehiculo(VehiculoConstant.MOTO).size() < VehiculoConstant.LIMITE_MOTOS_PARQUEADAS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO);
	}

	public boolean lugarDisponibleEnParqueaderoCarro() throws PreconditionException {
		if(parqueaderoJpaRepository.findByTipoVehiculo(VehiculoConstant.CARRO).size() < VehiculoConstant.LIMITE_CARROS_PARQUEADOS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO);
	}	
	
}
