package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.parqueadero.ParqueaderoModel;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

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
