package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import java.util.List;

import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;

public interface VehiculosParqueados {

	public List<ParqueaderoModel> vehiculosParqueados();
	
}
