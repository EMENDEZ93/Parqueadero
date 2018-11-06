package em.parqueadero.backend.domain.vehiculo.factory.segregration;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;

public interface CalcularCostoParqueo {

	public double calcularCostoParqueo(ParqueaderoEntity parqueaderoEntity);
	
}
