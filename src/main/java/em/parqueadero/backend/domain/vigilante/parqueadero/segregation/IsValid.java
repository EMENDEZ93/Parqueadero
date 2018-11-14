package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface IsValid {

	public boolean isValid(VehiculoDto vehiculo) throws PreconditionException;
	
}
