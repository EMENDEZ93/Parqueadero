package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso;

import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public interface CondicionCilindrajeRecargo {

	public double condicionCilindrajeRecargo(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity);
	
}
