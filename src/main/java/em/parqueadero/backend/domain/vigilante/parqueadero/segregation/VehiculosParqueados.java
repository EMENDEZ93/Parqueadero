package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import java.util.List;

import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.RegistroVehiculoParqueaderoDto;

public interface VehiculosParqueados {

	public List<RegistroVehiculoParqueaderoDto> vehiculosParqueados();
	
}
