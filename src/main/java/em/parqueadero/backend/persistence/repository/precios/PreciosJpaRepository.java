package em.parqueadero.backend.persistence.repository.precios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;

@Repository("tipoVehiculoJpaRepository")
public interface PreciosJpaRepository extends JpaRepository<PreciosEntity, Serializable> {

	public abstract PreciosEntity findByNombre(String nombre);
	
}
