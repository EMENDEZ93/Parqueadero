package em.parqueadero.backend.domain.vehiculo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.vehiculo.impl.VehiculoServiceImpl;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehiculoServiceTest {

	@InjectMocks
	private VehiculoServiceImpl vehiculoService;
	
	private Vehiculo vehiculo;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void placaIniciaConATest() {
		//arrange
		vehiculo = new VehiculoTestDataBuilder().setPlaca("ABC50").setTipoVehiculo("Moto").build();

		//act
		boolean placaIniciaConA = vehiculoService.placaIniciConA(vehiculo);
		
		//assert
		assertTrue(placaIniciaConA);
		
	}

	@Test
	public void placaIniciaDiferenteDeATest() {
		//arrange
		vehiculo = new VehiculoTestDataBuilder().setPlaca("BC50r").setTipoVehiculo("Carro").build();

		//act
		boolean placaIniciaConA = vehiculoService.placaIniciConA(vehiculo);
		
		//assert
		assertFalse(placaIniciaConA);
		
	}
	
}
