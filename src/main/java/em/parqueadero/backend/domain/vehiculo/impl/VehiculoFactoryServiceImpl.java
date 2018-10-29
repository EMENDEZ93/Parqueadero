package em.parqueadero.backend.domain.vehiculo.impl;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;

@Service("vehiculoFactoryService")
public class VehiculoFactoryServiceImpl implements VehiculoFactoryService {

	@Override
	public VehiculoService getService(String tipoVehiculo) {
		switch (tipoVehiculo) {
		case "MOTO":
			return new MotoServiceImpl();

		case "CARRO":
			return new CarroServiceImpl();

		default:
			return null;
		}
	}

}
