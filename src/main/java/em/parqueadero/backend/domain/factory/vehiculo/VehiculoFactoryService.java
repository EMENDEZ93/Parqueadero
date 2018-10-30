package em.parqueadero.backend.domain.factory.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public interface VehiculoFactoryService {

	public VehiculoService getService(Vehiculo vehiculo) throws PreconditionException;
	
}
