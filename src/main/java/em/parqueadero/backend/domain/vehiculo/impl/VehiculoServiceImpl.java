package em.parqueadero.backend.domain.vehiculo.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.Factory;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.CambioEstadoParqueo;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.ExisteVehiculoParquedo;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.ObtenerFechaSalida;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService, ExisteVehiculoParquedo, CambioEstadoParqueo, ObtenerFechaSalida {

	@Autowired
	private Factory factory;

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	public boolean placaIniciConA(VehiculoModel vehiculo) {
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
	public ParqueaderoEntity ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException {
		existeVehiculoParquedo(vehiculo.getPlaca());

		if (placaIniciConA(vehiculo)) {
			ingresoVehiculoSoloDomingoLunes();
			return factory.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		} else {

			return factory.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		}

	}

	@Override
	public boolean existeVehiculoParquedo(String placa) throws PreconditionException {
		if (!parqueaderoJpaRepository.existsByParqueadoJoinPlaca(placa).isEmpty()) {
			throw new PreconditionException(ConstantExcep.VEHICULO_PARQUEADO_CON_ESTAS_PLACAS + placa);
		}

		return true;
	}

	@Override
	public ParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		ParqueaderoEntity parqueaderoEntity = cambioEstadoParqueoAFalse(idParqueaderoEntity);
		parqueaderoEntity.setFechaSalida( obtenerFechaSalida() );	
		return parqueaderoJpaRepository.save(parqueaderoEntity);
	}

	@Override
	public ParqueaderoEntity cambioEstadoParqueoAFalse(int idParqueaderoEntity) {
		ParqueaderoEntity parqueaderoEntity = parqueaderoJpaRepository.getOne(idParqueaderoEntity);
		parqueaderoEntity.setParqueado(false);
		return parqueaderoEntity;
	}

	@Override
	public LocalDateTime obtenerFechaSalida() {
		return LocalDateTime.now();
	}


}
