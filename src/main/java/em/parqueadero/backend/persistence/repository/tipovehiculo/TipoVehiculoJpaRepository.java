package em.parqueadero.backend.persistence.repository.tipovehiculo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.tarifatipovehiculo.TarifaTipoVehiculoEntity;

@Repository("tipoVehiculoJpaRepository")
public interface TipoVehiculoJpaRepository extends JpaRepository<TarifaTipoVehiculoEntity, Serializable> {

	public abstract TarifaTipoVehiculoEntity findByNombre(String nombre);
	
}
