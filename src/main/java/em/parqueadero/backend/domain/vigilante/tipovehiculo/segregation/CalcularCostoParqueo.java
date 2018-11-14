package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import java.time.Duration;

import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TarifaTipoVehiculoEntity;
import em.parqueadero.backend.persistence.repository.tipovehiculo.TipoVehiculoJpaRepository;

public interface CalcularCostoParqueo {

	public default double calcularCostoParqueo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity, TipoVehiculoJpaRepository tipoVehiculoJpaRepository ) {
		TarifaTipoVehiculoEntity tipoVehiculoEntity = tipoVehiculoJpaRepository
				.findByNombre(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());

		int horasDeParqueo = (int) Duration
				.between(registroVehiculoParqueaderoEntity.getFechaIngreso(), registroVehiculoParqueaderoEntity.getFechaSalida()).plusHours(1)
				.toHours();
		
		return obtenerCostoLogica(tipoVehiculoEntity, horasDeParqueo);
	}
	
	public default double obtenerCostoLogica(TarifaTipoVehiculoEntity tipoVehiculoEntity, int horasDeParqueo) {
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
