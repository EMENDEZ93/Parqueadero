package em.parqueadero.backend.domain.vigilante.tipovehiculo.moto;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.CalcularCostoParqueo;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.CondicionCilindrajeRecargo;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.CrearVehiculo;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.IsValid;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.LugarDisponibleParqueo;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.RegistroParqueadero;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;
import em.parqueadero.backend.persistence.repository.tipovehiculo.TipoVehiculoJpaRepository;
import em.parqueadero.backend.persistence.repository.vehiculo.VehiculoJpaRepository;

@Service
public class MotoServiceImpl implements VigilanteService, LugarDisponibleParqueo, IsValid, CrearVehiculo,
		RegistroParqueadero, CalcularCostoParqueo, CondicionCilindrajeRecargo {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;

	@Autowired
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;

	@Override
	public boolean lugarDisponibleParqueo() throws PreconditionException {
		if (parqueaderoJpaRepository.getAllParqueaderoEntityByMotoAndParqueado()
				.size() < VehiculoConstant.LIMITE_MOTOS_PARQUEADAS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO);
	}

	@Override
	public boolean isValid(VehiculoModel vehiculo) throws PreconditionException {

		if (vehiculo.getPlaca().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}

		if (vehiculo.getTipoVehiculo().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);
		}

		if (vehiculo.getCilindraje() == 0) {
			throw new PreconditionException(ConstantExcep.CILINDRAJE_NO_VALIDO);
		}

		return true;

	}

	@Override
	public void ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException {
		isValid(vehiculo);
		lugarDisponibleParqueo();
		VehiculoEntity vehiculoEntity = crearVehiculo(vehiculo);
		registroParqueadero(vehiculoEntity);
	}

	@Override
	public RegistroVehiculoParqueaderoEntity registroParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException {

		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new RegistroVehiculoParqueaderoEntity();
		registroVehiculoParqueaderoEntity.setVehiculoEntity(vehiculoEntity);

		return parqueaderoJpaRepository.save(registroVehiculoParqueaderoEntity);
	}

	@Override
	public VehiculoEntity crearVehiculo(VehiculoModel vehiculo) {
		if (vehiculoJpaRepository.existsByPlaca(vehiculo.getPlaca())) {
			return vehiculoJpaRepository.findByPlaca(vehiculo.getPlaca());
		}

		return vehiculoJpaRepository.save(VehiculoBuilder.convertirVehiculoModelAEntity(vehiculo));
	}

	@Override
	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = parqueaderoJpaRepository.getOne(idParqueaderoEntity);

		registroVehiculoParqueaderoEntity.setSeEncuentraParqueado(false);
		registroVehiculoParqueaderoEntity.setFechaSalida(LocalDateTime.now());
		registroVehiculoParqueaderoEntity.setCosto(calcularCostoParqueo(registroVehiculoParqueaderoEntity, tipoVehiculoJpaRepository)
				+ condicionCilindrajeRecargo(registroVehiculoParqueaderoEntity));
		return parqueaderoJpaRepository.save(registroVehiculoParqueaderoEntity);
	}

	@Override
	public double condicionCilindrajeRecargo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity) {
		if (registroVehiculoParqueaderoEntity.getVehiculoEntity().getCilindraje() > VehiculoConstant.CILINDRAJE_LIMITE_SIN_RECARGO) {
			return VehiculoConstant.COSTO_RECARGO_CILINDRAJE;
		}
		return 0;
	}

}
