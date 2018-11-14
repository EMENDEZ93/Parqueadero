package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.tipovehiculo.TipoVehiculoModel;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TarifaTipoVehiculoEntity;

public final class TipoVehiculoBuilder {

	private TipoVehiculoBuilder() {}
	
	public static TipoVehiculoModel convertirTipoVehiculoEntityAModel(TarifaTipoVehiculoEntity tipoVehiculoEntity) {

		TipoVehiculoModel tipoVehiculoModel = null;

		if (tipoVehiculoEntity != null) {
			tipoVehiculoModel = new TipoVehiculoModel(tipoVehiculoEntity.getIdTipoVehiculo(),
					tipoVehiculoEntity.getNombre());
		}

		return tipoVehiculoModel;
	}

	public static TarifaTipoVehiculoEntity convertirTipoVehiculoModelAEntity(TipoVehiculoModel tipoVehiculoModel) {
		
		TarifaTipoVehiculoEntity tipoVehiculoEntity = new TarifaTipoVehiculoEntity();
		tipoVehiculoEntity.setNombre(tipoVehiculoModel.getNombre());
		
		return tipoVehiculoEntity;
	}
	
}
