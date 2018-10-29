package em.parqueadero.backend.entity.parqueadero;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.PrePersist;

import em.parqueadero.backend.entity.tipovehiculo.TipoVehiculo;

@Entity
@Table()
public class Parqueadero implements Serializable {

	private static final long serialVersionUID = -6585773340404494121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParqueadero;

	private Integer cilindraje;

	@NotNull
	private String placa;

	private Calendar fechaIngreso;

	@ManyToOne(fetch=FetchType.LAZY)
	private TipoVehiculo tipoVehiculo;
	
	@PrePersist
	public void PrePersist() {
		fechaIngreso = Calendar.getInstance();
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

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
