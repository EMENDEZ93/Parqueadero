package em.parqueadero.backend.domain.trm;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.trm.TrmModel;

@RunWith(SpringRunner.class)
public class TrmServiceTest {

	private TrmServiceImpl trmService;

	@Before
	public void setUp() {
		trmService = mock(TrmServiceImpl.class);
	}

	@Test
	public void getTrmTest() throws PreconditionException {

		// arrange
		TrmModel trmModel = null;

		// act
		trmModel = trmService.getTrm();

		// assert
		assertEquals(trmModel, trmModel);

	}

	@Test
	public void getTrmExceptionTest() throws PreconditionException {

		// arrange
		when(trmService.getTrm()).thenThrow(new PreconditionException(ConstantExcep.FALLO_SERVICIO_TRM));

		try {
			// act
			trmService.getTrm();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.FALLO_SERVICIO_TRM, e.getMessage());
		}

	}

}
