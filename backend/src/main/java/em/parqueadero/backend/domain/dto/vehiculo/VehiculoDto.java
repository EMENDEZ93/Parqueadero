package em.parqueadero.backend.domain.dto.vehiculo;

import em.parqueadero.backend.domain.dto.vehiculo.validacion.uniqueplaca.UniquePlaca;

public class VehiculoDto {

	private int idVehiculo;

	@UniquePlaca(message = "Existe un vehiculo parqueado con esta placa!!!")
	private String placa;

	private String tipoVehiculo;

	private int cilindraje;

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
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

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

}
