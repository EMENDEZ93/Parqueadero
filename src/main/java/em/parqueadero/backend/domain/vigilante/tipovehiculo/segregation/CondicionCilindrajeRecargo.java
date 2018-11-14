package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;

public interface CondicionCilindrajeRecargo {

	public double condicionCilindrajeRecargo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity);
	
}
