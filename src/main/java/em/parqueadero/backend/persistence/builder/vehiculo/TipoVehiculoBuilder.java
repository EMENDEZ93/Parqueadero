package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.persistence.model.tipovehiculo.TipoVehiculoModel;

public final class TipoVehiculoBuilder {

	private TipoVehiculoBuilder() {}
	
	public static TipoVehiculoModel convertirTipoVehiculoEntityAModel(TipoVehiculoEntity tipoVehiculoEntity) {

		TipoVehiculoModel tipoVehiculoModel = null;

		if (tipoVehiculoEntity != null) {
			tipoVehiculoModel = new TipoVehiculoModel(tipoVehiculoEntity.getIdTipoVehiculo(),
					tipoVehiculoEntity.getNombre());
		}

		return tipoVehiculoModel;
	}

	public static TipoVehiculoEntity convertirTipoVehiculoModelAEntity(TipoVehiculoModel tipoVehiculoModel) {
		
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setNombre(tipoVehiculoModel.getNombre());
		
		return tipoVehiculoEntity;
	}
	
}
