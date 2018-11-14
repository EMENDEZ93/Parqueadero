package em.parqueadero.backend.domain.vigilante;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public interface VigilanteService {

	public void ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException;

	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException;
	
}
