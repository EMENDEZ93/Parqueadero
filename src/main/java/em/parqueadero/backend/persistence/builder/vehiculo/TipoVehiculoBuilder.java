package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.tipovehiculo.TipoVehiculoModel;
import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;

public final class TipoVehiculoBuilder {

	private TipoVehiculoBuilder() {}
	
	public static TipoVehiculoModel convertirTipoVehiculoEntityAModel(PreciosEntity tipoVehiculoEntity) {

		TipoVehiculoModel tipoVehiculoModel = null;

		if (tipoVehiculoEntity != null) {
			tipoVehiculoModel = new TipoVehiculoModel(tipoVehiculoEntity.getIdTipoVehiculo(),
					tipoVehiculoEntity.getNombre());
		}

		return tipoVehiculoModel;
	}

	public static PreciosEntity convertirTipoVehiculoModelAEntity(TipoVehiculoModel tipoVehiculoModel) {
		
		PreciosEntity tipoVehiculoEntity = new PreciosEntity();
		tipoVehiculoEntity.setNombre(tipoVehiculoModel.getNombre());
		
		return tipoVehiculoEntity;
	}
	
}
