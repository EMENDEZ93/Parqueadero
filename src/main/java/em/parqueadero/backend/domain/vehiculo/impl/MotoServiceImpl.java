package em.parqueadero.backend.domain.vehiculo.impl;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;

public class MotoServiceImpl implements VehiculoService {

	@Override
	public String tipoVehiculo() {
		return "moto";
	}

}
