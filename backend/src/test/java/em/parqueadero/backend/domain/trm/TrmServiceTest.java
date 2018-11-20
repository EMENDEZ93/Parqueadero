package em.parqueadero.backend.domain.trm;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.trm.TrmDto;
import em.parqueadero.backend.domain.exception.preconditionexception.TrmException;

@RunWith(SpringRunner.class)
public class TrmServiceTest {

	private TrmServiceImpl trmService;

	@Before
	public void setUp() {
		trmService = Mockito.spy(TrmServiceImpl.class);
	}

	@Test
	public void getTrmTest() throws Exception {

		// arrange
		TrmDto trmModel = null;

		// act
		trmModel = trmService.getTrm();

		// assert
		assertEquals(trmModel, trmModel);

	}

	@Test
	public void getTrmNotWorkingTest() throws Exception {

		// arrange

		try {

			// act
			when(trmService.getTrm()).thenThrow(new TrmException(ConstantExcep.FALLO_SERVICIO_TRM));

		} catch (TrmException e) {

			// assert
			assertEquals(ConstantExcep.FALLO_SERVICIO_TRM, e.getMessage());

		}

	}
	
}
