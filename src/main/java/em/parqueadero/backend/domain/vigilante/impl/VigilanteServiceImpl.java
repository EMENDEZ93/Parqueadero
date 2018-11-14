package em.parqueadero.backend.domain.vigilante.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.parqueadero.ParqueaderoModel;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.TipoVehiculoFactory;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.ExisteVehiculoParquedo;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.segregation.VehiculosParqueados;
import em.parqueadero.backend.persistence.builder.vehiculo.ParqueaderoBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;

@Service("vigilante")
public class VigilanteServiceImpl implements VigilanteService, ExisteVehiculoParquedo, VehiculosParqueados {

	@Autowired
	private TipoVehiculoFactory tipoVehiculo;

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
	public void ingresoVehiculoParqueadero(VehiculoModel vehiculo) throws PreconditionException {
		existeVehiculoParquedo(vehiculo.getPlaca());

		if (placaIniciConA(vehiculo)) {
			ingresoVehiculoSoloDomingoLunes();
			tipoVehiculo.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		} else {

			tipoVehiculo.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

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
	public RegistroVehiculoParqueaderoEntity salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		VehiculoModel vehiculo = VehiculoBuilder.convertirVehiculoEntityAModel(
				parqueaderoJpaRepository.getOne(idParqueaderoEntity).getVehiculoEntity());

		return tipoVehiculo.getService(vehiculo).salidaVehiculoParqueadero(idParqueaderoEntity);

	}

	@Override
	public List<ParqueaderoModel> vehiculosParqueados() {

		List<ParqueaderoModel> parqueaderoModels = new ArrayList<>();
		parqueaderoJpaRepository.getAllBySeEncuentraParqueadoIsTrue().stream().forEach(parqueaderoEntity -> parqueaderoModels
				.add(ParqueaderoBuilder.convertirParqueaderoEntityAModel(parqueaderoEntity)));

		return parqueaderoModels;
	}

}
