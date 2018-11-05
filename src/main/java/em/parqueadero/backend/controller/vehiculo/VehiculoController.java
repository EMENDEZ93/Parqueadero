package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.persistence.model.vehiculo.Vehiculo;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping("/ingreso/vehiculo")
	public Vehiculo ingresoVehiculoParqueadero(@Valid @RequestBody Vehiculo vehiculo) throws PreconditionException {
		return vehiculoService.ingresoVehiculoParqueadero(vehiculo);
	}
	
}
