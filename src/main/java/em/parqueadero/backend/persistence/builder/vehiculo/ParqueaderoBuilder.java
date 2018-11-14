package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;

public final class ParqueaderoBuilder {

	private ParqueaderoBuilder() {
	}

	public static ParqueaderoModel convertirParqueaderoEntityAModel(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity) {

		ParqueaderoModel parqueaderoModel = null;

		if (registroVehiculoParqueaderoEntity != null) {
			parqueaderoModel = new ParqueaderoModel();
			parqueaderoModel.setId(registroVehiculoParqueaderoEntity.getIdParqueadero());
			parqueaderoModel.setPlaca(registroVehiculoParqueaderoEntity.getVehiculoEntity().getPlaca());
			parqueaderoModel.setTipo(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());
			parqueaderoModel.setFechaIngreso(registroVehiculoParqueaderoEntity.getFechaIngreso());
		}

		return parqueaderoModel;
	}

}
