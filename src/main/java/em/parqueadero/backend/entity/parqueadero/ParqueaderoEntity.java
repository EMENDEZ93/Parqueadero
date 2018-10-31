package em.parqueadero.backend.entity.parqueadero;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.PrePersist;

@Entity
@Table()
public class ParqueaderoEntity implements Serializable {

	private static final long serialVersionUID = -6585773340404494121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParqueadero;

	private Integer cilindraje;

	@NotNull
	private String placa;

	private LocalDateTime fechaIngreso;
	
	private String tipoVehiculo;
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@PrePersist
	public void prePersist() {
		fechaIngreso = LocalDateTime.now();
	}
	
	public Integer getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(Integer idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
