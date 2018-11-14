package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public interface CrearRegistroVehiculoEnParqueadero {

	public void crearRegistroVehiculoEnParqueadero(VehiculoEntity vehiculoEntity) throws PreconditionException;
	
}
