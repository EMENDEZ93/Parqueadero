package em.parqueadero.backend.domain.vehiculo.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface IngresoVehiculoSoloDomingoLunes {

	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException;
	
}
