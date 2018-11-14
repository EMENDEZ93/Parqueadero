package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.RegistroVehiculoParqueaderoDto;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public final class ParqueaderoBuilder {

	private ParqueaderoBuilder() {
	}

	public static RegistroVehiculoParqueaderoDto convertirParqueaderoEntityAModel(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity) {

		RegistroVehiculoParqueaderoDto parqueaderoModel = null;

		if (registroVehiculoParqueaderoEntity != null) {
			parqueaderoModel = new RegistroVehiculoParqueaderoDto();
			parqueaderoModel.setId(registroVehiculoParqueaderoEntity.getIdParqueadero());
			parqueaderoModel.setPlaca(registroVehiculoParqueaderoEntity.getVehiculoEntity().getPlaca());
			parqueaderoModel.setTipo(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());
			parqueaderoModel.setFechaIngreso(registroVehiculoParqueaderoEntity.getFechaIngreso());
		}

		return parqueaderoModel;
	}

}
