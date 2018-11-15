package em.parqueadero.backend.persistence.builder.vehiculo;

import em.parqueadero.backend.domain.dto.factura.FacturaDto;
import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.VehiculosParqueadosDto;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public final class RegistroVehiculoParqueaderoBuilder {

	private RegistroVehiculoParqueaderoBuilder() {
	}

	public static VehiculosParqueadosDto convertirParqueaderoEntityADto(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity) {

		VehiculosParqueadosDto parqueaderoModel = null;

		if (registroVehiculoParqueaderoEntity != null) {
			parqueaderoModel = new VehiculosParqueadosDto();
			parqueaderoModel.setId(registroVehiculoParqueaderoEntity.getIdParqueadero());
			parqueaderoModel.setPlaca(registroVehiculoParqueaderoEntity.getVehiculoEntity().getPlaca());
			parqueaderoModel.setTipo(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo());
			parqueaderoModel.setFechaIngreso(registroVehiculoParqueaderoEntity.getFechaIngreso());
		}

		return parqueaderoModel;
	}

	public static FacturaDto convertirRegistroVehiculoParqueaderoEntityAFacturaDto(RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity) {
		
		FacturaDto factura = null;
		
		if(registroVehiculoParqueaderoEntity != null) {
			factura = new FacturaDto(); 
			factura.setCosto(registroVehiculoParqueaderoEntity.getCosto());
			factura.setTiempoPorCancelar(registroVehiculoParqueaderoEntity.getTiempoParqueado());
			factura.setPlaca(registroVehiculoParqueaderoEntity.getVehiculoEntity().getPlaca());
			factura.setTipoVehiculo(registroVehiculoParqueaderoEntity.getVehiculoEntity().getTipoVehiculo()); 
		}
		
		return factura; 
	}
	
}
