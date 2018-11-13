package em.parqueadero.backend.domain.vigilante.factory.segregration;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public interface IsValid {

	public boolean isValid(VehiculoModel vehiculo) throws PreconditionException;
	
}
