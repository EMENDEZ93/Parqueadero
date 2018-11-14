package em.parqueadero.backend.domain.dto.factura;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FacturaDto implements Serializable {

	private static final long serialVersionUID = 2164544924623632482L;

	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private String tiempoPorCancelar;
	private double costo;

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getTiempoPorCancelar() {
		return tiempoPorCancelar;
	}

	public void setTiempoPorCancelar(String tiempoPorCancelar) {
		this.tiempoPorCancelar = tiempoPorCancelar;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

}
