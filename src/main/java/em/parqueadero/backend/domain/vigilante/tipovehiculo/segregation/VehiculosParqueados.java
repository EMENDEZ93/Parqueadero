package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import java.util.List;

import em.parqueadero.backend.domain.dto.parqueadero.RegistroVehiculoParqueaderoDto;

public interface VehiculosParqueados {

	public List<RegistroVehiculoParqueaderoDto> vehiculosParqueados();
	
}
