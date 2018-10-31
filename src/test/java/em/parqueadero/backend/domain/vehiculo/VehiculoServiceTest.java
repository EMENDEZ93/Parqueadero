package em.parqueadero.backend.domain.vehiculo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

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

	@Test
	public void vehiculolCondicionIngresoVehiculoDomingoLunes() throws Exception {
		//arrange
		vehiculo = new VehiculoTestDataBuilder().setPlaca("AAA").setTipoVehiculo("Carro").build();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Thread.sleep(3000);
		
		System.out.println( LocalDateTime.now() );

		long numberOfHours = Duration.between( localDateTime , LocalDateTime.now()).toHours();
	
		long numberOfHours2 = Duration.between( localDateTime , LocalDateTime.now()).toMillis();
		
		System.out.println(numberOfHours);	    
		System.out.println(numberOfHours2);
		System.out.println(localDateTime.getDayOfWeek());
		System.out.println(LocalDateTime.now().getDayOfWeek());
		
		LocalDateTime aDateTime = LocalDateTime.of(2018, Month.OCTOBER, 30, 16, 00, 40);

		System.out.println("*************************");
		System.out.println(aDateTime);
		
		System.out.println("*************************");
		long number = Duration.between( aDateTime , LocalDateTime.now()).toHours();
		System.out.println(number);
		
	}
	
}
