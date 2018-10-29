package em.parqueadero.backend.domain.vehiculo.impl;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;

public class CarroServiceImpl implements VehiculoService  {

	@Override
	public String tipoVehiculo() {
		return "carro";
	}

}
