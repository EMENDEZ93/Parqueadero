package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import java.time.Duration;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.repository.precios.PreciosJpaRepository;

public interface CalcularCostoParqueo {

	public default double calcularCostoParqueo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity, PreciosJpaRepository tipoVehiculoJpaRepository ) {
		PreciosEntity tipoVehiculoEntity = tipoVehiculoJpaRepository
				.findByNombre(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());

		int horasDeParqueo = (int) Duration
				.between(registroVehiculoParqueaderoEntity.getFechaIngreso(), registroVehiculoParqueaderoEntity.getFechaSalida()).plusHours(1)
				.toHours();
		
		return obtenerCostoLogica(tipoVehiculoEntity, horasDeParqueo);
	}
	
	public default double obtenerCostoLogica(PreciosEntity tipoVehiculoEntity, int horasDeParqueo) {
		int diasPorPagar = horasDeParqueo / CondicionesParqueaderoConstant.HORAS_AL_DIA;
		double totalPagar = 0;

		if (diasPorPagar > 0) {
			horasDeParqueo = horasDeParqueo - (CondicionesParqueaderoConstant.HORAS_AL_DIA * diasPorPagar);
			totalPagar = diasPorPagar * tipoVehiculoEntity.getCostoDia();

			if (horasDeParqueo >= CondicionesParqueaderoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
				diasPorPagar++;
				totalPagar = diasPorPagar * tipoVehiculoEntity.getCostoDia();
			} else {
				totalPagar = totalPagar + (horasDeParqueo * tipoVehiculoEntity.getCostoHora());
			}

		} else if (horasDeParqueo >= CondicionesParqueaderoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
			totalPagar = tipoVehiculoEntity.getCostoDia();
		} else {
			totalPagar = horasDeParqueo * tipoVehiculoEntity.getCostoHora();
		}

		return totalPagar;
	}
	
}
