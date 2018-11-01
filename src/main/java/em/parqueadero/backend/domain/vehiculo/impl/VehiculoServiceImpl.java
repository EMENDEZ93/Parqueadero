package em.parqueadero.backend.domain.vehiculo.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.segregation.IngresoVehiculoSoloDomingoLunes;
import em.parqueadero.backend.domain.vehiculo.segregation.PlacaIniciaConA;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService, PlacaIniciaConA, IngresoVehiculoSoloDomingoLunes {

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
	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException {
		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES);
	}

}
