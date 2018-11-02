package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping("/ingreso/vehiculo")
	public VehiculoEntity ingresoVehiculoParqueadero(@Valid @RequestBody Vehiculo vehiculo) throws PreconditionException {
		return vehiculoService.ingresoVehiculoParqueadero(vehiculo);
	}
	
}
