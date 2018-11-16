package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public interface CrearVehiculo {

	public VehiculoEntity crearVehiculo(VehiculoDto vehiculo);
	
}
