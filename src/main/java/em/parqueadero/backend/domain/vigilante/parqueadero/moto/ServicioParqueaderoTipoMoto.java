package em.parqueadero.backend.domain.vigilante.parqueadero.moto;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.factura.FacturaDto;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.ValidarCondicionCilindrajeRecargo;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.CrearRegistroVehiculoEnParqueadero;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.CrearVehiculo;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.EsValidoVehiculoDto;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.VerificarLugarDisponibleParqueadero;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.salida.CalcularCostoParqueo;
import em.parqueadero.backend.persistence.builder.vehiculo.RegistroVehiculoParqueaderoBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.repository.precios.PreciosJpaRepository;
import em.parqueadero.backend.persistence.repository.registrovehiculoparqueadero.RegistroVehiculoParqueaderoJpaRepository;
import em.parqueadero.backend.persistence.repository.vehiculo.VehiculoJpaRepository;

@Service
public class ServicioParqueaderoTipoMoto implements VigilanteService, VerificarLugarDisponibleParqueadero, EsValidoVehiculoDto,
		CrearVehiculo, CrearRegistroVehiculoEnParqueadero, CalcularCostoParqueo, ValidarCondicionCilindrajeRecargo {

	@Autowired
	private RegistroVehiculoParqueaderoJpaRepository parqueaderoJpaRepository;

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;

	@Autowired
	private PreciosJpaRepository tipoVehiculoJpaRepository;

	@Override
	public boolean verificarLugarDisponibleParqueo() throws PreconditionException {
		if (parqueaderoJpaRepository.getAllParqueaderoEntityByMotoAndParqueado()
				.size() < CondicionesParqueaderoConstant.LIMITE_MOTOS_PARQUEADAS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO);
	}

	@Override
	public boolean esValidoVehiculoDto(VehiculoDto vehiculo) throws PreconditionException {

		if (vehiculo.getPlaca().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}

		if (vehiculo.getTipoVehiculo().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);
		}

		if (vehiculo.getCilindraje() <= 0) {
			throw new PreconditionException(ConstantExcep.CILINDRAJE_NO_VALIDO);
		}

		return true;

	}

	@Override
	public void ingresoVehiculoParqueadero(VehiculoDto vehiculo) throws PreconditionException {
		esValidoVehiculoDto(vehiculo);
		verificarLugarDisponibleParqueo();
		VehiculoEntity vehiculoEntity = crearVehiculo(vehiculo);
		crearRegistroVehiculoEnParqueadero(vehiculoEntity);
	}

	@Override
	public void crearRegistroVehiculoEnParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException {

		RegistroVehiculoParqueaderoEntity registroVehiculoParqueadero = new RegistroVehiculoParqueaderoEntity();
		registroVehiculoParqueadero.setVehiculoEntity(vehiculoEntity);

		parqueaderoJpaRepository.save(registroVehiculoParqueadero);
	}

	@Override
	public VehiculoEntity crearVehiculo(VehiculoDto vehiculo) {
		if (vehiculoJpaRepository.existsByPlaca(vehiculo.getPlaca())) {
			return vehiculoJpaRepository.findByPlaca(vehiculo.getPlaca());
		}

		return vehiculoJpaRepository.save(VehiculoBuilder.convertirVehiculoDtoAEntity(vehiculo));
	}

	@Override
	public FacturaDto salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		RegistroVehiculoParqueaderoEntity registroSalida = parqueaderoJpaRepository.getOne(idParqueaderoEntity);

		registroSalida.setSeEncuentraParqueado(false);
		registroSalida.setFechaSalida(LocalDateTime.now());
		registroSalida.setCosto(calcularCostoParqueo(registroSalida, tipoVehiculoJpaRepository)
				+ validarCondicionCilindrajeRecargo(registroSalida));
		registroSalida.setTiempoParqueado(
				obtenerTiempoParqueado(registroSalida.getFechaIngreso(), registroSalida.getFechaSalida()));
		return RegistroVehiculoParqueaderoBuilder
				.convertirRegistroVehiculoParqueaderoEntityAFacturaDto(parqueaderoJpaRepository.save(registroSalida));
	}

	@Override
	public double validarCondicionCilindrajeRecargo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueadero) {
		if (registroVehiculoParqueadero.getVehiculoEntity()
				.getCilindraje() > CondicionesParqueaderoConstant.CILINDRAJE_LIMITE_SIN_RECARGO) {
			return CondicionesParqueaderoConstant.COSTO_RECARGO_CILINDRAJE;
		}
		return 0;
	}

}
