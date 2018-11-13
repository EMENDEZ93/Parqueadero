package em.parqueadero.backend.domain.vigilante.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.factory.Factory;
import em.parqueadero.backend.domain.vigilante.factory.segregration.ExisteVehiculoParquedo;
import em.parqueadero.backend.domain.vigilante.factory.segregration.VehiculosParqueados;
import em.parqueadero.backend.persistence.builder.vehiculo.ParqueaderoBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;

@Service("vehiculoService")
public class VigilanteServiceImpl implements VigilanteService, ExisteVehiculoParquedo, VehiculosParqueados {

	@Autowired
	private Factory factory;

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	public boolean placaIniciConA(VehiculoModel vehiculo) {
		return String.valueOf(vehiculo.getPlaca()).startsWith("A");
	}

	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException {
		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES);
	}

	@Override
	public ParqueaderoEntity ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException {
		existeVehiculoParquedo(vehiculo.getPlaca());

		if (placaIniciConA(vehiculo)) {
			ingresoVehiculoSoloDomingoLunes();
			return factory.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		} else {

			return factory.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		}

	}

	@Override
	public boolean existeVehiculoParquedo(String placa) throws PreconditionException {
		if (!parqueaderoJpaRepository.existsByParqueadoJoinPlaca(placa).isEmpty()) {
			throw new PreconditionException(ConstantExcep.VEHICULO_PARQUEADO_CON_ESTAS_PLACAS + placa);
		}

		return true;
	} 

	@Override
	public ParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		VehiculoModel vehiculo = VehiculoBuilder.convertirVehiculoEntityAModel(
				parqueaderoJpaRepository.getOne(idParqueaderoEntity).getVehiculoEntity());

		return factory.getService(vehiculo).salidaVehiculoParqueadero(idParqueaderoEntity);

	}

	@Override
	public List<ParqueaderoModel> vehiculosParqueados() {

		List<ParqueaderoModel> parqueaderoModels = new ArrayList<>();
		parqueaderoJpaRepository.getAllByParqueadoIsTrue().stream().forEach(parqueaderoEntity -> 
			parqueaderoModels.add( ParqueaderoBuilder.convertirParqueaderoEntityAModel(parqueaderoEntity) )
		);

		return parqueaderoModels;
	}

}
