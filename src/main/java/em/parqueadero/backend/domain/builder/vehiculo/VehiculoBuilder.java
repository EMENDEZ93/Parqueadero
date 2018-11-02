package em.parqueadero.backend.domain.builder.vehiculo;

import em.parqueadero.backend.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

public class VehiculoBuilder {

	private VehiculoBuilder() {
	}

	public static Vehiculo convertToModel(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;

		if (vehiculoEntity != null) {
			vehiculo = new Vehiculo();
			vehiculo.setPlaca(vehiculoEntity.getPlaca());
			vehiculo.setTipoVehiculo(vehiculoEntity.getTipoVehiculo());
			vehiculo.setCilindraje(vehiculoEntity.getCilindraje());
		}

		return vehiculo;
	}

	public static VehiculoEntity convertToEntity(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		
		return vehiculoEntity;
	}
}
