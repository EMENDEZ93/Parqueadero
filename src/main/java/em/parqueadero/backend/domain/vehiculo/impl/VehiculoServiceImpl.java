package em.parqueadero.backend.domain.vehiculo.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.Factory;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.Vehiculo;
import em.parqueadero.backend.persistence.repository.vehiculo.VehiculoJpaRepository;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoJpaRepository vehiculoJpaRepository;
	
	@Autowired
	private Factory factory;
		
	public VehiculoEntity ingresoVehiculoParqueaderoEntity(VehiculoEntity vehiculoEntity) {
		
		return vehiculoJpaRepository.save(vehiculoEntity);
	
	}
	
	public boolean placaIniciConA(Vehiculo vehiculo) {
		return String.valueOf(vehiculo.getPlaca()).startsWith("A");
	}

	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException {
		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES);
	}
	
}
