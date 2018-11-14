package em.parqueadero.backend.domain.vigilante.parqueadero.carro;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.segregation.CalcularCostoParqueo;
import em.parqueadero.backend.domain.vigilante.parqueadero.segregation.CrearVehiculo;
import em.parqueadero.backend.domain.vigilante.parqueadero.segregation.EsValidoVehiculoDto;
import em.parqueadero.backend.domain.vigilante.parqueadero.segregation.LugarDisponibleParqueadero;
import em.parqueadero.backend.domain.vigilante.parqueadero.segregation.CrearRegistroVehiculoEnParqueadero;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.repository.precios.PreciosJpaRepository;
import em.parqueadero.backend.persistence.repository.registrovehiculoparqueadero.RegistroVehiculoParqueaderoJpaRepository;
import em.parqueadero.backend.persistence.repository.vehiculo.VehiculoJpaRepository;

@Service
public class ServicioParqueaderoTipoCarro implements VigilanteService, LugarDisponibleParqueadero, EsValidoVehiculoDto, CrearVehiculo,
		CrearRegistroVehiculoEnParqueadero, CalcularCostoParqueo {

	@Autowired
	private RegistroVehiculoParqueaderoJpaRepository parqueaderoJpaRepository;

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;

	@Autowired
	private PreciosJpaRepository tipoVehiculoJpaRepository;

	@Override
	public boolean lugarDisponibleParqueo() throws PreconditionException {
		if (parqueaderoJpaRepository.getAllParqueaderoEntityByCarroAndParqueado()
				.size() < CondicionesParqueaderoConstant.LIMITE_CARROS_PARQUEADOS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO);
	}

	@Override
	public boolean esValidoVehiculoDto(VehiculoDto vehiculo) throws PreconditionException {

		if (vehiculo.getPlaca().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}

		if (vehiculo.getTipoVehiculo().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);
		}

		return true;
	}

	@Override
	public void ingresoVehiculoParqueadero(VehiculoDto vehiculo) throws PreconditionException {
		esValidoVehiculoDto(vehiculo);
		lugarDisponibleParqueo();
		VehiculoEntity vehiculoEntity = crearVehiculo(vehiculo);
		crearRegistroVehiculoEnParqueadero(vehiculoEntity);
	}

	@Override
	public VehiculoEntity crearVehiculo(VehiculoDto vehiculo) {
		if (vehiculoJpaRepository.existsByPlaca(vehiculo.getPlaca())) {
			return vehiculoJpaRepository.findByPlaca(vehiculo.getPlaca());
		}

		return vehiculoJpaRepository.save(VehiculoBuilder.convertirVehiculoDtoAEntity(vehiculo));
	}

	@Override
	public void crearRegistroVehiculoEnParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException {
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new RegistroVehiculoParqueaderoEntity();
		registroVehiculoParqueaderoEntity.setVehiculoEntity(vehiculoEntity);

		parqueaderoJpaRepository.save(registroVehiculoParqueaderoEntity);
	}

	@Override
	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = parqueaderoJpaRepository.getOne(idParqueaderoEntity);
		registroVehiculoParqueaderoEntity.setSeEncuentraParqueado(false);
		registroVehiculoParqueaderoEntity.setFechaSalida(LocalDateTime.now());
		registroVehiculoParqueaderoEntity.setCosto(calcularCostoParqueo(registroVehiculoParqueaderoEntity, tipoVehiculoJpaRepository));

		return parqueaderoJpaRepository.save(registroVehiculoParqueaderoEntity);
	} 

}
