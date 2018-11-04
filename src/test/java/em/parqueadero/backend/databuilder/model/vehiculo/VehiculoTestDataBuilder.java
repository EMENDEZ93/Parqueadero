package em.parqueadero.backend.databuilder.model.vehiculo;

import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.persistence.model.vehiculo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "333-EDW";
	private static final String TIPOVEHICULO = VehiculoConstant.CARRO;
	private static final int CILINDRAJE = 300;
	
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.cilindraje = CILINDRAJE;
	}

	public VehiculoTestDataBuilder setPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder setTipoVehiculo(String tipoVehiculp) {
		this.tipoVehiculo=tipoVehiculp;
		return this;
	}	

	public VehiculoTestDataBuilder setCilindraje(int cilindraje) {
		this.cilindraje=cilindraje;
		return this;
	}	
	
	public Vehiculo build() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(this.placa);
		vehiculo.setTipoVehiculo(this.tipoVehiculo);
		vehiculo.setCilindraje(this.cilindraje);
		return vehiculo;
	}
	
}
