package em.parqueadero.backend.domain.factory.vehiculo.impl;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.impl.CarroServiceImpl;
import em.parqueadero.backend.domain.vehiculo.impl.MotoServiceImpl;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service("vehiculoFactoryService")
public class VehiculoFactoryServiceImpl implements VehiculoFactoryService {

	@Override
	public VehiculoService getService(Vehiculo vehiculo) {
		
		switch (vehiculo.getTipoVehiculo()) {
		case "MOTO":
			return new MotoServiceImpl();

		case "CARRO":
			return new CarroServiceImpl();
		default:
			return null;
		}
	}

}
