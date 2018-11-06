package em.parqueadero.backend.domain.vehiculo.factory.segregration;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;

public interface CalcularCostoParqueo {

	public double calcularCostoParqueo(ParqueaderoEntity parqueaderoEntity);
	
	public double obtenerCostoLogica(TipoVehiculoEntity tipoVehiculoEntity, int horasDeParqueo);

}
