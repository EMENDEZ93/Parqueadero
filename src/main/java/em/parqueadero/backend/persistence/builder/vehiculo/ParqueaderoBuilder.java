package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;

public final class ParqueaderoBuilder {

	private ParqueaderoBuilder() {
	}

	public static ParqueaderoModel convertirParqueaderoEntityAModel(ParqueaderoEntity parqueaderoEntity) {

		ParqueaderoModel parqueaderoModel = null;

		if (parqueaderoEntity != null) {
			parqueaderoModel = new ParqueaderoModel();
			parqueaderoModel.setId(parqueaderoEntity.getIdParqueadero());
			parqueaderoModel.setPlaca(parqueaderoEntity.getVehiculoEntity().getPlaca());
			parqueaderoModel.setTipo(parqueaderoEntity.getVehiculoEntity().getTipoVehiculo());
			parqueaderoModel.setFechaIngreso(parqueaderoEntity.getFechaIngreso());
		}

		return parqueaderoModel;
	}

}
