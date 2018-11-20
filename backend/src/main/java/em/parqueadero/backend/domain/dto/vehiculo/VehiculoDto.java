package em.parqueadero.backend.domain.dto.vehiculo;

import javax.validation.constraints.NotNull;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.vehiculo.validacion.existtipovehiculo.ExistTipoVehiculo;
import em.parqueadero.backend.domain.dto.vehiculo.validacion.notstring.NotNegative;
import em.parqueadero.backend.domain.dto.vehiculo.validacion.uniqueplaca.UniquePlaca;

public class VehiculoDto {

	private int idVehiculo;

	@UniquePlaca(message = ConstantExcep.VEHICULO_PARQUEADO_CON_ESTA_PLACA)
	@NotNull(message = ConstantExcep.PLACA_NO_VALIDA)
	private String placa;

	@ExistTipoVehiculo(message = ConstantExcep.TIPO_VEHICULO_NO_EXISTE)
	private String tipoVehiculo;

	@NotNegative(message = ConstantExcep.CILINDRAJE_NO_DEBE_SER_NEGATIVO)
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
