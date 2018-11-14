package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface ExisteVehiculoParqueado {

	public boolean existeVehiculoParqueado (String placa) throws PreconditionException;
	
}
