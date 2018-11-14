package em.parqueadero.backend.domain.trm;

import em.parqueadero.backend.domain.dto.trm.TrmModel;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface TrmService {

	public TrmModel getTrm() throws PreconditionException;
	
}
