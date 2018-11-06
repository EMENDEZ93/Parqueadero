package em.parqueadero.backend.domain.vehiculo.factory.carro;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.CalcularCostoParqueo;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.CrearVehiculo;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.IsValid;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.LugarDisponibleParqueo;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.RegistroParqueadero;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;
import em.parqueadero.backend.persistence.repository.tipovehiculo.TipoVehiculoJpaRepository;
import em.parqueadero.backend.persistence.repository.vehiculo.VehiculoJpaRepository;

@Service
public class CarroServiceImpl implements VehiculoService, LugarDisponibleParqueo, IsValid, CrearVehiculo,
		RegistroParqueadero, CalcularCostoParqueo {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;

	@Autowired
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;

	@Override
	public boolean lugarDisponibleParqueo() throws PreconditionException {
		if (parqueaderoJpaRepository.getAllParqueaderoEntityByCarroAndParqueado()
				.size() < VehiculoConstant.LIMITE_CARROS_PARQUEADOS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO);
	}

	@Override
	public boolean isValid(VehiculoModel vehiculo) throws PreconditionException {

		if (vehiculo.getPlaca().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}

		if (vehiculo.getTipoVehiculo().trim().isEmpty()) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);
		}

		return true;
	}

	@Override
	public ParqueaderoEntity ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException {
		isValid(vehiculo);
		lugarDisponibleParqueo();
		VehiculoEntity vehiculoEntity = crearVehiculo(vehiculo);
		return registroParqueadero(vehiculoEntity);
	}

	@Override
	public VehiculoEntity crearVehiculo(VehiculoModel vehiculo) {
		if (vehiculoJpaRepository.existsByPlaca(vehiculo.getPlaca())) {
			return vehiculoJpaRepository.findByPlaca(vehiculo.getPlaca());
		}

		return vehiculoJpaRepository.save(VehiculoBuilder.convertirVehiculoModelAEntity(vehiculo));
	}

	@Override
	public ParqueaderoEntity registroParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException {

		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity();
		parqueaderoEntity.setVehiculoEntity(vehiculoEntity);

		return parqueaderoJpaRepository.save(parqueaderoEntity);
	}

	@Override
	public ParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		ParqueaderoEntity parqueaderoEntity = parqueaderoJpaRepository.getOne(idParqueaderoEntity);
		parqueaderoEntity.setParqueado(false);
		parqueaderoEntity.setFechaSalida(LocalDateTime.now());
		parqueaderoEntity.setCosto(calcularCostoParqueo(parqueaderoEntity));

		return parqueaderoJpaRepository.save(parqueaderoEntity);
	}

	@Override
	public double calcularCostoParqueo(ParqueaderoEntity parqueaderoEntity) {
		TipoVehiculoEntity tipoVehiculoEntity = tipoVehiculoJpaRepository
				.findByNombre(parqueaderoEntity.getVehiculoEntity().getTipoVehiculo());

		int horasDeParqueo = (int) Duration
				.between(parqueaderoEntity.getFechaIngreso(), parqueaderoEntity.getFechaSalida()).plusHours(1)
				.toHours(); 

		return obtenerCostoLogica(tipoVehiculoEntity, horasDeParqueo);
	}

	@Override
	public double obtenerCostoLogica(TipoVehiculoEntity tipoVehiculoEntity, int horasDeParqueo) {
		int diasPorPagar = horasDeParqueo / VehiculoConstant.HORAS_AL_DIA;
		double totalPagar = 0;

		if (diasPorPagar > 0) {
			horasDeParqueo = horasDeParqueo - (VehiculoConstant.HORAS_AL_DIA * diasPorPagar);
			totalPagar = diasPorPagar * tipoVehiculoEntity.getCostoDia();

			if (horasDeParqueo >= VehiculoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
				diasPorPagar++;
				totalPagar = diasPorPagar * tipoVehiculoEntity.getCostoDia();
			} else {
				totalPagar = totalPagar + (horasDeParqueo * tipoVehiculoEntity.getCostoHora());
			}

		} else if (horasDeParqueo >= VehiculoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
			totalPagar = tipoVehiculoEntity.getCostoDia();
		} else {
			totalPagar = horasDeParqueo * tipoVehiculoEntity.getCostoHora();
		}

		return totalPagar;
	}

}
