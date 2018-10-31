package em.parqueadero.backend.domain.vehiculo.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.segregation.CondicionIngresoVehiculoDomingoLunes;
import em.parqueadero.backend.domain.vehiculo.segregation.PlacaIniciaConA;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService, PlacaIniciaConA, CondicionIngresoVehiculoDomingoLunes {

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

	@Override
	public boolean condicinIngresoVehiculoDomingoLunes(Vehiculo vehiculo) {
		
		//if(vehiculo.getFechaIngreso().getDayOfWeek() == Calendar.SUNDAY ) {}
		return false;
	}


}
