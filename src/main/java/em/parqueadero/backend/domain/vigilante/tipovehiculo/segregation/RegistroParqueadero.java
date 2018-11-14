package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public interface RegistroParqueadero {

	public RegistroVehiculoParqueaderoEntity registroParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException;
	
}
