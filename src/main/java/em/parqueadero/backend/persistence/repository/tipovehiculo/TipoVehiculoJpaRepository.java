package em.parqueadero.backend.persistence.repository.tipovehiculo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;

@Repository("tipoVehiculoJpaRepository")
public interface TipoVehiculoJpaRepository extends JpaRepository<TipoVehiculoEntity, Serializable> {

}
