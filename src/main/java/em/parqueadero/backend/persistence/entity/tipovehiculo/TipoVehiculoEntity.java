package em.parqueadero.backend.persistence.entity.tipovehiculo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TipoVehiculoEntity implements Serializable {

	private static final long serialVersionUID = 5686253391476674271L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoVehiculo;

	private String nombre;

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
