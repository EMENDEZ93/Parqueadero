package em.parqueadero.backend.domain.vehiculo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.impl.VehiculoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public class VehiculoServiceTest {

	private VehiculoServiceImpl vehiculoService;
	
	@Before
	public void setUp() {
		vehiculoService = Mockito.mock(VehiculoServiceImpl.class);
	}

	@Test
	public void placaIniciaConA() throws PreconditionException {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().setPlaca("AC50").buildModel();
		when( vehiculoService.placaIniciConA(vehiculo) ).thenCallRealMethod();
		
		// act
		boolean vehiculoIniciaConA = vehiculoService.placaIniciConA(vehiculo);

		// assert
		assertTrue(vehiculoIniciaConA);

	}

	@Test
	public void placaNoIniciaConA() throws PreconditionException {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().setPlaca("BC50").buildModel();
		
		// act
		boolean vehiculoIniciaConA = vehiculoService.placaIniciConA(vehiculo);

		// assert
		assertFalse(vehiculoIniciaConA);

	}

	@Test
	public void ingresoVehiculoEnDomingoLunes() throws PreconditionException {

		// arrange
		when(vehiculoService.ingresoVehiculoSoloDomingoLunes()).thenReturn(true);

		// act
		boolean ingresoDomingoLunes = vehiculoService.ingresoVehiculoSoloDomingoLunes();

		// assert
		assertTrue(ingresoDomingoLunes);

	}

	@Test
	public void ingresoVehiculoDiferenteADomingoLunes() throws PreconditionException {

		// arrange
		when(vehiculoService.ingresoVehiculoSoloDomingoLunes())
				.thenThrow(new PreconditionException(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES));

		try {

			// act
			vehiculoService.ingresoVehiculoSoloDomingoLunes();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PARQUEAR_SOLO_DOMINGO_LUNES, e.getMessage());
		}

	}

}
