package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public final class VehiculoBuilder {

	private VehiculoBuilder() {}
	
	public static VehiculoModel convertirVehiculoEntityAModel(VehiculoEntity vehiculoEntity) {
		
		VehiculoModel vehiculoModel = null;
		
		if(vehiculoEntity != null) {
			vehiculoModel = new VehiculoModel();
			vehiculoModel.setPlaca( vehiculoEntity.getPlaca() );
			vehiculoModel.setTipoVehiculo( vehiculoEntity.getTipoVehiculo() );
			vehiculoModel.setCilindraje(vehiculoEntity.getCilindraje() );
		}
		
		return vehiculoModel;
	}
	
	public static VehiculoEntity convertirVehiculoModelAEntity(VehiculoModel vehiculoModel) {
		
		VehiculoEntity vehiculoEntity = null;
		
		if( vehiculoModel != null ) {
			vehiculoEntity = new VehiculoEntity();
			vehiculoEntity.setPlaca( vehiculoModel.getPlaca() );
			vehiculoEntity.setTipoVehiculo( vehiculoModel.getTipoVehiculo() );
			vehiculoEntity.setCilindraje( vehiculoModel.getCilindraje() );
		}
		
		return vehiculoEntity;
	}
	
}
