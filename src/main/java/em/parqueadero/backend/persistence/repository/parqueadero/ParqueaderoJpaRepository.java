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

	@Query("select p.vehiculoEntity from ParqueaderoEntity p where p.parqueado=true and p.vehiculoEntity.placa = ?1")
	public List<VehiculoEntity> existsByParqueadoJoinPlaca(@Param("placa") String placa);

	@Query("select p from ParqueaderoEntity p where p.vehiculoEntity.tipoVehiculo ='Moto' and p.parqueado=true ")
	public List<ParqueaderoEntity> getAllParqueaderoEntityByMotoAndParqueado();

	@Query("select p from ParqueaderoEntity p where p.vehiculoEntity.tipoVehiculo ='Carro' and p.parqueado=true ")
	public List<ParqueaderoEntity> getAllParqueaderoEntityByCarroAndParqueado();

	public abstract List<ParqueaderoEntity> getAllByParqueadoIsTrue();

}
