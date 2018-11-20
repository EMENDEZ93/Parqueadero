package em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

import javax.persistence.PrePersist;

@Entity
@Table()
public class RegistroVehiculoParqueaderoEntity implements Serializable {

	private static final long serialVersionUID = -6585773340404494121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParqueadero;

	private LocalDateTime fechaIngreso;

	@ManyToOne
	@JoinColumn(referencedColumnName = "placa")
	private VehiculoEntity vehiculo;

	private boolean seEncuentraParqueado;

	private double costo;

	private LocalDateTime fechaSalida;

	private String tiempoParqueado;
	
	@PrePersist
	public void prePersist() {
		fechaIngreso = LocalDateTime.now();
		seEncuentraParqueado = true;
		costo = 0;
	}

	public int getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(int idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public VehiculoEntity getVehiculoEntity() {
		return vehiculo;
	}

	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculo = vehiculoEntity;
	}

	public boolean isParqueado() {
		return seEncuentraParqueado;
	}

	public void setSeEncuentraParqueado(boolean parqueado) {
		this.seEncuentraParqueado = parqueado;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getTiempoParqueado() {
		return tiempoParqueado;
	}

	public void setTiempoParqueado(String tiempoParqueado) {
		this.tiempoParqueado = tiempoParqueado;
	}

}
