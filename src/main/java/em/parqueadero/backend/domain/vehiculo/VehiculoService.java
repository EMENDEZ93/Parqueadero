package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public interface VehiculoService {

	public VehiculoModel ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException;
	
}
