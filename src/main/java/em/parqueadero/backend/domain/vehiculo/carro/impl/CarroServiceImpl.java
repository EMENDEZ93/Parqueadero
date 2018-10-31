package em.parqueadero.backend.domain.vehiculo.carro.impl;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.segregation.Save;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service
public class CarroServiceImpl implements VehiculoService, Save {

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) {
		return vehiculo;
	}

	@Override
	public Vehiculo save() {
		return null;
	}

}
