package em.parqueadero.backend.domain.vigilante.parqueadero.moto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.parqueadero.ParqueaderoTestDataBuilder;
import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.parqueadero.moto.ServicioParqueaderoTipoMoto;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

@RunWith(SpringRunner.class)
public class MotoServiceTest {

	@MockBean
	private ServicioParqueaderoTipoMoto motoService;

	private ServicioParqueaderoTipoMoto motoServiceImpl;

	@Before
	public void setUp() {
		motoServiceImpl = new ServicioParqueaderoTipoMoto();
	}

	@Test
	public void lugarDisponibleParqueoMotoTest() throws PreconditionException {

		// arrange
		when(motoService.lugarDisponibleParqueo()).thenReturn(true);

		// act
		boolean lugarDisponible = motoService.lugarDisponibleParqueo();

		// assert
		assertTrue(lugarDisponible);

	}

	@Test
	public void lugarNoDisponibleParqueoMotoTest() throws PreconditionException {

		// arrange
		when(motoService.lugarDisponibleParqueo())
				.thenThrow(new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO));

		try {

			// act
			motoService.lugarDisponibleParqueo();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO, e.getMessage());

		}

	}

	@Test
	public void validarDatosVehiculoTipoMoto() throws PreconditionException {

		// arrange
		VehiculoDto moto = new VehiculoTestDataBuilder().setPlaca("AC500").setTipoVehiculo(CondicionesParqueaderoConstant.MOTO)
				.setCilindraje(100).buildModel();

		// act
		boolean datosValidos = motoServiceImpl.esValidoVehiculoDto(moto);

		// assert
		assertTrue(datosValidos);

	}

	@Test
	public void placaNoValidaMoto() throws PreconditionException {

		// arrange
		VehiculoDto moto = new VehiculoTestDataBuilder().setPlaca("").setTipoVehiculo(CondicionesParqueaderoConstant.MOTO)
				.setCilindraje(100).buildModel();

		try {

			// act
			motoServiceImpl.esValidoVehiculoDto(moto);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PLACA_NO_VALIDA, e.getMessage());

		}

	}

	@Test
	public void tipoVehiculoNoValidoVacioMoto() throws PreconditionException {

		// arrange
		VehiculoDto moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo("").setCilindraje(100)
				.buildModel();

		try {

			// act
			motoServiceImpl.esValidoVehiculoDto(moto);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_VALIDO, e.getMessage());

		}

	}

	@Test
	public void cilingrajeNoValidoEnCeroMoto() throws PreconditionException {

		// arrange
		VehiculoDto moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo(CondicionesParqueaderoConstant.MOTO)
				.setCilindraje(0).buildModel();

		try {

			// act
			motoServiceImpl.esValidoVehiculoDto(moto);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.CILINDRAJE_NO_VALIDO, e.getMessage());

		}

	}

	@Test
	public void condicionCilindrajeRecargoMayorACilindrajeLimite() throws PreconditionException {

		// arrange
		VehiculoEntity moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo(CondicionesParqueaderoConstant.MOTO)
				.setCilindraje(600).buildEntity();
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new ParqueaderoTestDataBuilder().buildEntity();
		registroVehiculoParqueaderoEntity.setVehiculoEntity(moto);

		// act
		double recargo = motoServiceImpl.condicionCilindrajeRecargo(registroVehiculoParqueaderoEntity);

		// assert
		assertEquals(CondicionesParqueaderoConstant.COSTO_RECARGO_CILINDRAJE, recargo, 0.0);
	}

	@Test
	public void condicionCilindrajeRecargoMenorACilindrajeLimite() throws PreconditionException {

		// arrange
		VehiculoEntity moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo(CondicionesParqueaderoConstant.MOTO)
				.setCilindraje(400).buildEntity();
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new ParqueaderoTestDataBuilder().buildEntity();
		registroVehiculoParqueaderoEntity.setVehiculoEntity(moto);

		// act
		double recargo = motoServiceImpl.condicionCilindrajeRecargo(registroVehiculoParqueaderoEntity);

		// assert
		assertEquals(0.0, recargo, 0.0);
	}

}
