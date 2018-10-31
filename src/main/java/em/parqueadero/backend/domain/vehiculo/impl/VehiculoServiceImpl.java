package em.parqueadero.backend.domain.vehiculo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.segregation.PlacaIniciaConA;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService, PlacaIniciaConA {

	@Autowired
	@Qualifier("vehiculoFactoryService")
	private VehiculoFactoryService vehiculoFactoryService;
	
	@Autowired
	private VehiculoService vehiculoService;

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException {
		vehiculoService = vehiculoFactoryService.getService(vehiculo);
		return vehiculoService.tipoVehiculo(vehiculo);
	}

	@Override
	public Vehiculo ingresoVehiculoParqueadero() {
		return null;
	}

	@Override
	public boolean placaIniciConA(Vehiculo vehiculo) {
		return String.valueOf(vehiculo.getPlaca()).startsWith("A");
	}

}
