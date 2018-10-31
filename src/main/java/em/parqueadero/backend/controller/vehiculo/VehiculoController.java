package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.carro.impl.CarroServiceImpl;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.tipovehiculo.TipoVehiculoJpaRepository;

@RestController
public class VehiculoController {

	@Autowired
	@Qualifier("vehiculoService")
	private VehiculoService vehiculoService;
	
	@Autowired
	private CarroServiceImpl carroService;
	
	@Autowired
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;
	
	
	@GetMapping("/")
	public Vehiculo index() throws PreconditionException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("333hhh");
		vehiculo.setTipoVehiculo("MOTO");
		
		return vehiculoService.tipoVehiculo(vehiculo);
	}
	
	@PostMapping("/vehiculo")
	public Vehiculo postVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
		return vehiculo;
	}
	
	@GetMapping("/t")
	public String index2() {
		return "test";
	}
	
}
