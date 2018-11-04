package em.parqueadero.backend.controller.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping("/")
	public Vehiculo ingresoVehiculoParqueadero() throws PreconditionException {
		return null;
	}
	
}
