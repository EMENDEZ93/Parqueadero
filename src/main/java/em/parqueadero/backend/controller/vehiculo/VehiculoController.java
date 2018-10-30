package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@RestController
public class VehiculoController {

	@Autowired
	@Qualifier("vehiculoService")
	private VehiculoService vehiculoService;
	
	@GetMapping("/")
	public Vehiculo index() {
		Vehiculo vehiculo = new Vehiculo("333hhh", "BICICLETA");
		return vehiculoService.tipoVehiculo(vehiculo);
	}
	
	@PostMapping("/vehiculo")
	public Vehiculo postVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
		return null;
	}
	
}
