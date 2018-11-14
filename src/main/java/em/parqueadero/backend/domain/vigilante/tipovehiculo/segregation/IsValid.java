package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface IsValid {

	public boolean isValid(VehiculoModel vehiculo) throws PreconditionException;
	
}
