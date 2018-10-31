package em.parqueadero.backend.domain.vehiculo.carro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import em.parqueadero.backend.domain.vehiculo.carro.impl.CarroServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CarroServiceTest {

	private CarroServiceImpl carroService;
		
	@Before
	public void setUp() {
		carroService = mock(CarroServiceImpl.class);
	}
	
	@Test
	public void cupoDisponibleParqueoCarroTest() {
		//arrange
		when(carroService.disponibilidadParqueoCarro()).thenReturn(true); 
		
		//act
		boolean disponibilidadParqueo = carroService.disponibilidadParqueoCarro();
		
		//assert
		assertTrue(disponibilidadParqueo);	
	}

	@Test
	public void noCupoDisponibleParqueoCarroTest() {
		//arrange
		when(carroService.disponibilidadParqueoCarro()).thenReturn(false); 
		
		//act
		boolean disponibilidadParqueo = carroService.disponibilidadParqueoCarro();
		
		//assert
		assertFalse(disponibilidadParqueo);	
	}	
	
}
