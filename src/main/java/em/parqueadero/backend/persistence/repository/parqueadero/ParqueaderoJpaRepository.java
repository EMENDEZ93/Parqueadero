package em.parqueadero.backend.persistence.repository.parqueadero;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

@Repository
public interface ParqueaderoJpaRepository extends JpaRepository<RegistroVehiculoParqueaderoEntity, Serializable> {

	@Query("select p.vehiculo from RegistroVehiculoParqueaderoEntity p where p.seEncuentraParqueado=true and p.vehiculo.placa = ?1")
	public List<VehiculoEntity> existsByParqueadoJoinPlaca(@Param("placa") String placa);

	@Query("select p from RegistroVehiculoParqueaderoEntity p where p.vehiculo.tipoVehiculo ='Moto' and p.seEncuentraParqueado=true ")
	public List<RegistroVehiculoParqueaderoEntity> getAllParqueaderoEntityByMotoAndParqueado();

	@Query("select p from RegistroVehiculoParqueaderoEntity p where p.vehiculo.tipoVehiculo ='Carro' and p.seEncuentraParqueado=true ")
	public List<RegistroVehiculoParqueaderoEntity> getAllParqueaderoEntityByCarroAndParqueado();

	public abstract List<RegistroVehiculoParqueaderoEntity> getAllBySeEncuentraParqueadoIsTrue();

}
