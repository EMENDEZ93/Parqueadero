package em.parqueadero.backend.domain.vehiculo.moto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import em.parqueadero.backend.domain.vehiculo.moto.impl.MotoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MotoServiceTest {

	private MotoServiceImpl motoService;
	
	@Before
	public void setUp() {
		motoService = mock(MotoServiceImpl.class);
	}
	
	@Test
	public void cupoDisponibleParqueoMotoTest() {
		//arrange
		when(motoService.disponibilidadParqueoMoto()).thenReturn(true);
		
		//act
		boolean disponibilidadParqueo = motoService.disponibilidadParqueoMoto();
		
		//assert
		assertTrue(disponibilidadParqueo);
	}

	@Test
	public void noCupoDisponibleParqueoMotoTest() {
		//arrange
		when(motoService.disponibilidadParqueoMoto()).thenReturn(false);
		
		//act
		boolean disponibilidadParqueo = motoService.disponibilidadParqueoMoto();
		
		//assert
		assertFalse(disponibilidadParqueo);
	}

}
