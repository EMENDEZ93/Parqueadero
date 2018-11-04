package em.parqueadero.backend.domain.vehiculo.factory.segregration;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public interface IsValid {

	public boolean isValid(Vehiculo vehiculo) throws PreconditionException;
	
}
