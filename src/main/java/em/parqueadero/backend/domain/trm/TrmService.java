package em.parqueadero.backend.domain.trm;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.trm.TrmModel;

public interface TrmService {

	public TrmModel getTrm() throws PreconditionException;
	
}
