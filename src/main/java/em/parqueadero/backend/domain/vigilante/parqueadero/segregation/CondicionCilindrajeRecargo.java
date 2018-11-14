package em.parqueadero.backend.domain.vigilante.parqueadero.segregation;

import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public interface CondicionCilindrajeRecargo {

	public double condicionCilindrajeRecargo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity);
	
}
