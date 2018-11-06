package em.parqueadero.backend.persistence.model.parqueadero;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParqueaderoModel implements Serializable {

	private static final long serialVersionUID = 3574019000671490684L;

	private String placa;

	private String tipoVehiculo;

	private LocalDateTime fechaIngreso;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
