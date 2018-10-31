package em.parqueadero.backend.domain.vehiculo.carro.impl;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.carro.CarroService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service
public class CarroServiceImpl implements VehiculoService, CarroService {

	@Override
	public Vehiculo save() {
		
		if(disponibilidadParqueoCarro()) {
			System.out.println("*******************************");
			System.out.println("No hay Disponibilidad Para Carros");
		}
		
		return null;
	}

	@Override
	public void delete(Vehiculo vehiculo) {
		
	}

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException {
		return null;
	}

	@Override
	public boolean disponibilidadParqueoCarro() {
		return false;
	}

}
