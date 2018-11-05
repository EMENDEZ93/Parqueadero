package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.vehiculo.Vehiculo;

public interface VehiculoService {

	public Vehiculo ingresoVehiculoParqueadero(Vehiculo vehiculo) throws PreconditionException;
	
}
