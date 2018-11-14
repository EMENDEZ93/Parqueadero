package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface ExisteVehiculoParquedo {

	public boolean existeVehiculoParqueado (String placa) throws PreconditionException;
	
}
