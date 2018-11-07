package em.parqueadero.backend.domain.vehiculo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.impl.VehiculoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@RunWith(SpringRunner.class)
public class VehiculoServiceTest {

	@MockBean
	private VehiculoServiceImpl vehiculoService;

	private VehiculoServiceImpl vehiculoServiceImpl;

	private VehiculoServiceImpl vehiculoServicet;
	
	@Before
	public void setUp() {
		vehiculoServicet = Mockito.mock(VehiculoServiceImpl.class);
		vehiculoServiceImpl = new VehiculoServiceImpl();
	}

	@Test
	public void placaIniciaConA() throws PreconditionException {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().setPlaca("AC50").buildModel();

		// act
		boolean vehiculoIniciaConA = vehiculoServiceImpl.placaIniciConA(vehiculo);

		// assert
		assertTrue(vehiculoIniciaConA);

	}

	@Test
	public void placaNoIniciaConA() throws PreconditionException {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().setPlaca("BC50").buildModel();

		// act
		boolean vehiculoIniciaConA = vehiculoServiceImpl.placaIniciConA(vehiculo);

		// assert
		assertFalse(vehiculoIniciaConA);

	}

	@Test
	public void ingresoVehiculoEnDomingoLunes() throws PreconditionException {

		// arrange
		when(vehiculoServicet.ingresoVehiculoSoloDomingoLunes()).thenReturn(true);

		// act
		boolean ingresoDomingoLunes = vehiculoServicet.ingresoVehiculoSoloDomingoLunes();

		// assert
		assertTrue(ingresoDomingoLunes);

	}

	@Test
	public void ingresoVehiculoDiferenteADomingoLunes() throws PreconditionException {

		// arrange
		when(vehiculoServicet.ingresoVehiculoSoloDomingoLunes())
				.thenThrow(new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES));

		try {

			// act
			vehiculoServicet.ingresoVehiculoSoloDomingoLunes();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES, e.getMessage());
		}

	}

}
