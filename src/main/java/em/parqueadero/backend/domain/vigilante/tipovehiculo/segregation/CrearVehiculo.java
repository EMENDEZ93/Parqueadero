package em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public interface CrearVehiculo {

	public VehiculoEntity crearVehiculo(VehiculoModel vehiculo);
	
}
