package em.parqueadero.backend.databuilder;

import org.springframework.stereotype.Component;

import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.persistence.model.tipovehiculo.TipoVehiculoModel;

@Component
public class TipoVehiculoTestDataBuilder {

	private static final String NOMBRE= "Carro";
	private static final int ID_TIPO_VEHICULO= 2;
	private static final double COSTO_HORA = 500;
	private static final double COSTO_DIA = 1500;
	
	private int idTipoVehiculo;
	private String nombre;
	
	public TipoVehiculoTestDataBuilder() {
		this.idTipoVehiculo = ID_TIPO_VEHICULO;
		this.nombre = NOMBRE;
	}
	
	public TipoVehiculoTestDataBuilder conIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo=idTipoVehiculo;
		return this;
	}

	public TipoVehiculoTestDataBuilder conNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}
	
	public TipoVehiculoModel build() {
		return new TipoVehiculoModel(this.idTipoVehiculo, this.nombre);
	}

	public TipoVehiculoEntity buildEntity() {
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setCostoDia(COSTO_DIA);
		tipoVehiculoEntity.setCostoHora(COSTO_HORA);
		tipoVehiculoEntity.setNombre(NOMBRE);
		tipoVehiculoEntity.setIdTipoVehiculo(1);
		
		return tipoVehiculoEntity;
	}
}
