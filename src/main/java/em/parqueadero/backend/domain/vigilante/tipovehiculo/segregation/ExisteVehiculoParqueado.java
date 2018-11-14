package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface ExisteVehiculoParqueado {

	public boolean existeVehiculoParqueado (String placa) throws PreconditionException;
	
}
