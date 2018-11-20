package em.parqueadero.backend.domain.dto.factura;

import java.io.Serializable;

public class FacturaDto implements Serializable {

	private static final long serialVersionUID = 2164544924623632482L;

	private String tiempoPorCancelar;
	private double costo;
	private String placa;
	private String tipoVehiculo;

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

}
