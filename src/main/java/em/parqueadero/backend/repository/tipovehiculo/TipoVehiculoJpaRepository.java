package em.parqueadero.backend.repository.tipovehiculo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.entity.tipovehiculo.TipoVehiculoEntity;

@Repository("tipoVehiculoJpaRepository")
public interface TipoVehiculoJpaRepository extends JpaRepository<TipoVehiculoEntity, Serializable> {

}
