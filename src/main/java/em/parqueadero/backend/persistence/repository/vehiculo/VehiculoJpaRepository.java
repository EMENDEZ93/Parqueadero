package em.parqueadero.backend.persistence.repository.vehiculo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

@Repository
public interface VehiculoJpaRepository extends JpaRepository<VehiculoEntity, Serializable>  {

}
