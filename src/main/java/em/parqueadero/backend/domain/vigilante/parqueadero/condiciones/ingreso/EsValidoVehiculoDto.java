package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface EsValidoVehiculoDto {

	public boolean esValidoVehiculoDto(VehiculoDto vehiculo) throws PreconditionException;
	
}
