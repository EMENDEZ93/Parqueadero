package em.parqueadero.backend.domain.vehiculo;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public interface VigilanteService {

	public ParqueaderoEntity ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException;

	public ParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException;
	
}
