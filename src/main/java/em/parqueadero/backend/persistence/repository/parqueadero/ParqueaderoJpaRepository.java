package em.parqueadero.backend.persistence.repository.parqueadero;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

@Repository
public interface ParqueaderoJpaRepository extends JpaRepository<ParqueaderoEntity, Serializable> {

	@Query("select p.vehiculoEntity from ParqueaderoEntity p where p.parqueado =?1 and p.vehiculoEntity.placa = ?2")
	public List<VehiculoEntity> existsByParqueadoJoinPlaca(@Param("parqueado")boolean parqueado, @Param("placa") String placa);
	
}
