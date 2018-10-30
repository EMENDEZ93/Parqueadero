package em.parqueadero.backend.controller.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;

@RestController
public class VehiculoController {

	@Autowired
	@Qualifier("vehiculoFactoryService")
	private VehiculoFactoryService vehiculoService;

	
	@GetMapping("/")
	public String index() {
		return vehiculoService.getService("CARRO").tipoVehiculo();
	}
}
