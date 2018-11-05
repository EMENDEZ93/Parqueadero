package em.parqueadero.backend.domain.vehiculo.factory.segregration;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;

public interface CambioEstadoParqueo {

	public ParqueaderoEntity cambioEstadoParqueoAFalse(int idParqueaderoEntity);
	
}
