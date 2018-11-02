package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public interface VehiculoService {

	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException;
	
	public VehiculoEntity ingresoVehiculoParqueadero(Vehiculo vehiculo) throws PreconditionException;
	
	public boolean lugarDisponibleEnParqueadero(Vehiculo vehiculo) throws PreconditionException;

}
