package em.parqueadero.backend.persistence.model.parqueadero;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParqueaderoModel implements Serializable {

	private static final long serialVersionUID = 3574019000671490684L;

	private int id;

	private String placa;

	private String tipo;

	private LocalDateTime fechaIngreso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipoVehiculo) {
		this.tipo = tipoVehiculo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
