package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public interface CrearVehiculo {

	public VehiculoEntity crearVehiculo(VehiculoModel vehiculo);
	
}
