package em.parqueadero.backend.domain.vehiculo.factory.segregration;

import java.util.List;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;

public interface VehiculosParqueados {

	public List<ParqueaderoModel> vehiculosParqueados();
	
}
