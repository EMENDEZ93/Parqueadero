package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;

public interface CambioEstadoParqueo {

	public RegistroVehiculoParqueaderoEntity cambioEstadoParqueoAFalse(int idParqueaderoEntity);
	
}
