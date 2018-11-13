package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public interface RegistroParqueadero {

	public ParqueaderoEntity registroParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException;
	
}
