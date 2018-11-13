package em.parqueadero.backend.domain.vigilante.factory.segregration;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface ExisteVehiculoParquedo {

	public boolean existeVehiculoParquedo (String placa) throws PreconditionException;
	
}
