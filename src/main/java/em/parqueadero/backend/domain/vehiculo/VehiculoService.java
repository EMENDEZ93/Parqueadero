package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.model.vehiculo.Vehiculo;

public interface VehiculoService {

	public Vehiculo tipoVehiculo(Vehiculo vehiculo);

	public Vehiculo save();
	
}
