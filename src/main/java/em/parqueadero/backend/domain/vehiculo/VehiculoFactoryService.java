package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;

public interface VehiculoFactoryService {

	public VehiculoService getService(String tipoVehiculo);	
	
}
