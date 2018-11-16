package em.parqueadero.backend.domain.vigilante.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.factura.FacturaDto;
import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.VehiculosParqueadosDto;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.TipoVehiculoFactory;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.ExisteVehiculoParqueado;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.VehiculosParqueados;
import em.parqueadero.backend.persistence.builder.vehiculo.RegistroVehiculoParqueaderoBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.VehiculoBuilder;
import em.parqueadero.backend.persistence.repository.registrovehiculoparqueadero.RegistroVehiculoParqueaderoJpaRepository;

@Service("vigilante")
public class VigilanteServiceImpl implements VigilanteService, ExisteVehiculoParqueado, VehiculosParqueados {

	@Autowired
	private TipoVehiculoFactory tipoVehiculo;

	@Autowired
	private RegistroVehiculoParqueaderoJpaRepository parqueaderoJpaRepository;

	public boolean placaIniciConA(VehiculoDto vehiculo) {
		return String.valueOf(vehiculo.getPlaca().toUpperCase()).startsWith(CondicionesParqueaderoConstant.LETRA_INICIAL);
	}

	public boolean ingresoVehiculoSoloDomingoLunes() throws PreconditionException {
		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES);
	}

	@Override
	public void ingresoVehiculoParqueadero(VehiculoDto vehiculo) throws PreconditionException {
		existeVehiculoParqueado(vehiculo.getPlaca());

		if (placaIniciConA(vehiculo)) {
			ingresoVehiculoSoloDomingoLunes();
			tipoVehiculo.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		} else {

			tipoVehiculo.getService(vehiculo).ingresoVehiculoParqueadero(vehiculo);

		}

	}

	@Override
	public boolean existeVehiculoParqueado(String placa) throws PreconditionException {
		if (!parqueaderoJpaRepository.existsByParqueadoJoinPlaca(placa).isEmpty()) {
			throw new PreconditionException(ConstantExcep.VEHICULO_PARQUEADO_CON_ESTA_PLACA + placa);
		}

		return true;
	}

	@Override
	public FacturaDto salidaVehiculoParqueadero(int idParqueaderoEntity) throws PreconditionException {
		VehiculoDto vehiculo = VehiculoBuilder.convertirVehiculoEntityADto(
				parqueaderoJpaRepository.getOne(idParqueaderoEntity).getVehiculoEntity());

		return tipoVehiculo.getService(vehiculo).salidaVehiculoParqueadero(idParqueaderoEntity);

	}

	@Override
	public List<VehiculosParqueadosDto> vehiculosParqueados() {

		List<VehiculosParqueadosDto> parqueaderoModels = new ArrayList<>();
		parqueaderoJpaRepository.getAllBySeEncuentraParqueadoIsTrue().stream().forEach(parqueaderoEntity -> parqueaderoModels
				.add(RegistroVehiculoParqueaderoBuilder.convertirParqueaderoEntityADto(parqueaderoEntity)));

		return parqueaderoModels;
	}

}
