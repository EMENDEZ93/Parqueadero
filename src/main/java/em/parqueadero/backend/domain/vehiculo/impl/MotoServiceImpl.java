package em.parqueadero.backend.domain.vehiculo.impl;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public class MotoServiceImpl implements VehiculoService {

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) {
		return vehiculo;
	}

	@Override
	public Vehiculo save() {
		return null;
	}

}
