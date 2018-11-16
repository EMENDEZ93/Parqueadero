package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.salida;

import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public interface CambioEstadoParqueo {

	public RegistroVehiculoParqueaderoEntity cambioEstadoParqueoAFalse(int idParqueaderoEntity);
	
}
