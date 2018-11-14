package em.parqueadero.backend.domain.vigilante;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public interface VigilanteService {

	public void ingresoVehiculoParqueadero(VehiculoDto vehiculo) throws PreconditionException;

	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException;
	
}
