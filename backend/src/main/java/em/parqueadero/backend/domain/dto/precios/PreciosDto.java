package em.parqueadero.backend.domain.dto.precios;

public class PreciosDto {

	private int idTipoVehiculo;

	private String nombre;

	public PreciosDto(int idTipoVehiculo, String nombre) {
		this.idTipoVehiculo = idTipoVehiculo;
		this.nombre = nombre;
	}

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
