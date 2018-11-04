package em.parqueadero.backend.domain.vehiculo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.impl.VehiculoServiceImpl;

@RunWith(SpringRunner.class)
public class VehiculoServiceTest {
/*
	private VehiculoServiceImpl vehiculoService;

	@Before
	public void setUp() {
		vehiculoService = mock(VehiculoServiceImpl.class);
	}

	@Test
	public void lugarDisponibleEnParqueaderoMoto() throws PreconditionException {
		// arrange
		when(vehiculoService.lugarDisponibleEnParqueaderoMoto()).thenReturn(true);

		// act
		boolean lugarDisponible = vehiculoService.lugarDisponibleEnParqueaderoMoto();

		// assert
		assertTrue(lugarDisponible);

	}

	@Test
	public void ExceptionNoDisponibleEnParqueaderoMoto() throws PreconditionException {
		// arrange
		when(vehiculoService.lugarDisponibleEnParqueaderoMoto())
				.thenThrow(new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO));

		try {
			// act
			vehiculoService.lugarDisponibleEnParqueaderoMoto();
		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO, e.getMessage());
		}

	}
*/
}
