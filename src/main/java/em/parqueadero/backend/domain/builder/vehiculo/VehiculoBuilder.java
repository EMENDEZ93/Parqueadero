package em.parqueadero.backend.domain.builder.vehiculo;

import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public class VehiculoBuilder {

	private VehiculoBuilder() {
	}

	public static VehiculoModel convertToModel(VehiculoEntity vehiculoEntity) {
		VehiculoModel vehiculo = null;

		if (vehiculoEntity != null) {
			vehiculo = new VehiculoModel();
			vehiculo.setPlaca(vehiculoEntity.getPlaca());
			vehiculo.setTipoVehiculo(vehiculoEntity.getTipoVehiculo());
			vehiculo.setCilindraje(vehiculoEntity.getCilindraje());
		}

		return vehiculo;
	}

	public static VehiculoEntity convertToEntity(VehiculoModel vehiculo) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		
		return vehiculoEntity;
	}
}
