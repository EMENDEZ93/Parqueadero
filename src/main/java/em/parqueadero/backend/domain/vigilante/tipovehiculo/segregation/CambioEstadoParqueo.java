package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;

public interface CambioEstadoParqueo {

	public ParqueaderoEntity cambioEstadoParqueoAFalse(int idParqueaderoEntity);
	
}
