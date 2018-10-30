package em.parqueadero.backend.databuilder.model.vehiculo;

import em.parqueadero.backend.model.vehiculo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "333-EDW";
	private static final String TIPOVEHICULO = "CARRO";

	private String placa;
	private String tipoVehiculo;

	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
	}

	public VehiculoTestDataBuilder setPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder setTipoVehiculo(String tipoVehiculp) {
		this.tipoVehiculo=tipoVehiculp;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.tipoVehiculo);
	}
	
}
