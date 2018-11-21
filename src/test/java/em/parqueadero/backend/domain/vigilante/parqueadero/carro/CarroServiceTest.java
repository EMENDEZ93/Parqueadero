package em.parqueadero.backend.domain.vigilante.parqueadero.carro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.parqueadero.carro.ServicioParqueaderoTipoCarro;

public class CarroServiceTest {

	private ServicioParqueaderoTipoCarro carroService;

	private ServicioParqueaderoTipoCarro carroServiceImpl;

	@Before
	public void setUp() {
		carroService =Mockito.mock(ServicioParqueaderoTipoCarro.class) ;
		carroServiceImpl = new ServicioParqueaderoTipoCarro();
	}

	@Test
	public void lugarDisponibleParqueoCarroTest() throws PreconditionException {

		// arrange
		when(carroService.verificarLugarDisponibleParqueo()).thenReturn(true);

		// act
		boolean lugarDisponibleCarro = carroService.verificarLugarDisponibleParqueo();

		// assert
		assertTrue(lugarDisponibleCarro);

	}

	@Test
	public void lugarNoDisponibleParqueoCarroTest() throws PreconditionException {

		// arrange
		when(carroService.verificarLugarDisponibleParqueo())
				.thenThrow(new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO));

		try {

			// act
			carroService.verificarLugarDisponibleParqueo();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO, e.getMessage());

		}

	}

	@Test
	public void validarDatosVehiculoTipoCarro() throws PreconditionException {

		// arrange
		VehiculoDto carro = new VehiculoTestDataBuilder().buildDto();

		// act
		boolean datosValidos = carroServiceImpl.esValidoVehiculoDto(carro);

		// assert
		assertTrue(datosValidos);

	}

	@Test
	public void placaNoValidaCarro() throws PreconditionException {

		// arrange
		VehiculoDto carro = new VehiculoTestDataBuilder().setPlaca("").buildDto();

		try {

			// act
			carroServiceImpl.esValidoVehiculoDto(carro);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PLACA_NO_VALIDA, e.getMessage());

		}
	}

	@Test
	public void tipoVehiculoNoValidoVacioCarro() throws PreconditionException {

		// arrange
		VehiculoDto carro = new VehiculoTestDataBuilder().setTipoVehiculo("").buildDto();

		try {

			// act
			carroServiceImpl.esValidoVehiculoDto(carro);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_VALIDO, e.getMessage());

		}
	}
	
}
