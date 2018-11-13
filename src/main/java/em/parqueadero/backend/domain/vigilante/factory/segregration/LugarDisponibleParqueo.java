package em.parqueadero.backend.domain.vigilante.factory.segregration;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface LugarDisponibleParqueo {

	public boolean lugarDisponibleParqueo() throws PreconditionException;
	
}
