package em.parqueadero.backend.controller.vigilante;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.trm.TrmService;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.VehiculosParqueados;
import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@CrossOrigin
@RestController
public class VigilanteController {

	@Autowired
	private VigilanteService vehiculoService;

	@Autowired
	private VehiculosParqueados vehiculosParqueados;

	@Autowired
	private TrmService trmService;

	@PostMapping("/v1/ingreso/vehiculo/parqueadero")
	public void ingresoVehiculoParqueadero(@Valid @RequestBody VehiculoModel vehiculo) throws PreconditionException {
		vehiculoService.ingresoVehiculoParqueadero(vehiculo);
	}

	@GetMapping("/salida/vehiculo/parqueadero/{idParqueaderoEntity}")
	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(
			@PathVariable(value = "idParqueaderoEntity") int idParqueaderoEntity) throws PreconditionException {
		return vehiculoService.salidaVehiculoParqueadero(idParqueaderoEntity);
	}

	@GetMapping("/vehiculos/parqueados")
	public List<ParqueaderoModel> vehiculosParqueados() {
		return vehiculosParqueados.vehiculosParqueados();
	}

	@GetMapping("/trm")
	public float getTrm() throws PreconditionException {
		return trmService.getTrm().getValue();
	}

}
