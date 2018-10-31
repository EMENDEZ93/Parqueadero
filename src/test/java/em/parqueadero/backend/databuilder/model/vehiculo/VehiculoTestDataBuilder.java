package em.parqueadero.backend.databuilder.model.vehiculo;

import java.time.LocalDateTime;
import java.time.Month;

import em.parqueadero.backend.model.vehiculo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "333-EDW";
	private static final String TIPOVEHICULO = "CARRO";
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.of(2018, Month.OCTOBER, 30, 16, 00, 40);
	
	private String placa;
	private String tipoVehiculo;
	private LocalDateTime fechaIngreso;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.fechaIngreso = FECHA_INGRESO;
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
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(this.placa);
		vehiculo.setTipoVehiculo(this.tipoVehiculo);
		vehiculo.setFechaIngreso(this.fechaIngreso);
		return vehiculo;
	}
	
}
