package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.precios.PreciosDto;
import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;

public final class PreciosBuilder {

	private PreciosBuilder() {}
	
	public static PreciosDto convertirTipoVehiculoEntityAModel(PreciosEntity tipoVehiculoEntity) {

		PreciosDto tipoVehiculoModel = null;

		if (tipoVehiculoEntity != null) {
			tipoVehiculoModel = new PreciosDto(tipoVehiculoEntity.getIdTipoVehiculo(),
					tipoVehiculoEntity.getNombre());
		}

		return tipoVehiculoModel;
	}

	public static PreciosEntity convertirTipoVehiculoModelAEntity(PreciosDto tipoVehiculoModel) {
		
		PreciosEntity tipoVehiculoEntity = new PreciosEntity();
		tipoVehiculoEntity.setNombre(tipoVehiculoModel.getNombre());
		
		return tipoVehiculoEntity;
	}
	
}
