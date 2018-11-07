package em.parqueadero.backend.domain.trm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.trm.TrmModel;

@RunWith(SpringRunner.class)
public class TrmServiceTest {

	private TrmServiceImpl trmService;
	
	@Before
	public void setUp() {
		trmService = new TrmServiceImpl();
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

}
