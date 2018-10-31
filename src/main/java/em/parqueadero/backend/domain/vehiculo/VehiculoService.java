package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.segregation.IngresoVehiculoParqueadero;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public interface VehiculoService extends IngresoVehiculoParqueadero {

	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException;
	
}
