package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping("/ingreso/vehiculo")
	public VehiculoModel ingresoVehiculoParqueadero(@Valid @RequestBody VehiculoModel vehiculo) throws PreconditionException {
		return vehiculoService.ingresoVehiculoParqueadero(vehiculo);
	}
	
}
