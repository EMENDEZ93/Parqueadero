package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.salida;

import java.time.Duration;
import java.time.LocalDateTime;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.repository.precios.PreciosJpaRepository;

public interface CalcularCostoParqueo {

	public default double calcularCostoParqueo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity,
			PreciosJpaRepository tipoVehiculoJpaRepository) {
		PreciosEntity tipoVehiculoEntity = tipoVehiculoJpaRepository
				.findByNombre(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());

		int horasDeParqueo = obtenerDiferenciaEnHoras(registroVehiculoParqueaderoEntity.getFechaIngreso(),
				registroVehiculoParqueaderoEntity.getFechaSalida());

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

	public default String obtenerTiempoParqueado(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		String tiempo = "";
		int horasDeParqueo = obtenerDiferenciaEnHoras(fechaIngreso, fechaSalida);
		int diasPorPagar = horasDeParqueo / CondicionesParqueaderoConstant.HORAS_AL_DIA;
		if (diasPorPagar > CondicionesParqueaderoConstant.MENOS_DE_UN_DIA) {
			horasDeParqueo = horasDeParqueo - (CondicionesParqueaderoConstant.HORAS_AL_DIA * diasPorPagar);
			if (horasDeParqueo >= CondicionesParqueaderoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
				diasPorPagar++;
				tiempo = "Dias : " + diasPorPagar;
			} else {
				tiempo = "Dias : " + diasPorPagar + " Horas: " + horasDeParqueo;
			}
		} else if (horasDeParqueo >= CondicionesParqueaderoConstant.HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA) {
			tiempo = "1 Dia";
		} else {
			tiempo = "Horas : " + horasDeParqueo;
		}

		return tiempo;
	}

	public default int obtenerDiferenciaEnHoras(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		return (int) Duration.between(fechaIngreso, fechaSalida).plusHours(1).toHours();
	}

}
