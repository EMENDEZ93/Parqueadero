package em.parqueadero.backend.model.vehiculo;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 2065015136721602875L;

	private String placa;

	private String tipoVehiculo;

	public Vehiculo(String placa, String tipoVehiculo) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
