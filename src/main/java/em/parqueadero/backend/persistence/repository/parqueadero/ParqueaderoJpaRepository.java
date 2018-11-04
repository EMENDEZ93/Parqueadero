package em.parqueadero.backend.persistence.repository.parqueadero;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;

@Repository
public interface ParqueaderoJpaRepository extends JpaRepository<ParqueaderoEntity, Serializable> {

	public List<ParqueaderoEntity> findByTipoVehiculo(String tipoVehiculo);

}