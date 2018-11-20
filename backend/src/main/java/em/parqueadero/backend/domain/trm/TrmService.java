package em.parqueadero.backend.domain.trm;

import em.parqueadero.backend.domain.dto.trm.TrmDto;
import em.parqueadero.backend.domain.exception.preconditionexception.TrmException;

public interface TrmService {

	public TrmDto getTrm() throws TrmException; 
	
}
