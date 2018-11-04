package em.parqueadero.backend.domain.vehiculo.factory.moto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@RunWith(SpringRunner.class)
public class MotoServiceTest {

	@MockBean
	private MotoServiceImpl motoService;

	private MotoServiceImpl motoServiceImpl;

	@Before
	public void setUp() {
		motoServiceImpl = new MotoServiceImpl();
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
		Vehiculo moto = new VehiculoTestDataBuilder().setPlaca("AC500").setTipoVehiculo(VehiculoConstant.MOTO).setCilindraje(100).build();
	
		// act
		boolean datosValidos = motoServiceImpl.isValid(moto);

		// assert
		assertTrue(datosValidos);

	}
	
	@Test
	public void placaNoValidaMoto() throws PreconditionException {

		// arrange
		Vehiculo moto = new VehiculoTestDataBuilder().setPlaca("").setTipoVehiculo(VehiculoConstant.MOTO).setCilindraje(100).build();
	
		try {

			// act
			motoServiceImpl.isValid(moto);
			
		}catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PLACA_NO_VALIDA, e.getMessage());
			
		}

	}

	@Test
	public void tipoVehiculoNoValidoVacioMoto() throws PreconditionException {

		// arrange
		Vehiculo moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo("").setCilindraje(100).build();

		try {
			
			// act
			motoServiceImpl.isValid(moto);
			
		}catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_VALIDO, e.getMessage());
			
		}
		
	}	

	@Test
	public void cilingrajeNoValidoEnCeroMoto() throws PreconditionException {

		// arrange
		Vehiculo moto = new VehiculoTestDataBuilder().setPlaca("AC50").setTipoVehiculo(VehiculoConstant.MOTO).setCilindraje(0).build();

		try {
			
			// act
			motoServiceImpl.isValid(moto);
			
		}catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.CILINDRAJE_NO_VALIDO, e.getMessage());
			
		}
		
	}	
	
}
