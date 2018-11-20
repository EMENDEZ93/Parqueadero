package em.parqueadero.backend.domain.vigilante;

import em.parqueadero.backend.domain.dto.factura.FacturaDto;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface VigilanteService {

	public void ingresoVehiculoParqueadero(VehiculoDto vehiculo) throws PreconditionException;

	public FacturaDto salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException;
	
}
