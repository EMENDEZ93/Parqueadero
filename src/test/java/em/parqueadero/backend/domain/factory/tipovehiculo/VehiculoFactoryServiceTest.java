package em.parqueadero.backend.domain.factory.tipovehiculo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.factory.vehiculo.impl.VehiculoFactoryServiceImpl;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.carro.impl.CarroServiceImpl;
import em.parqueadero.backend.domain.vehiculo.moto.impl.MotoServiceImpl;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehiculoFactoryServiceTest {

	@InjectMocks
	private VehiculoFactoryServiceImpl vehiculoFactoryService;

	private Vehiculo vehiculo;

	@Autowired
	private VehiculoService vehiculoService;

	@Before
	public void setUp() {
	}

	@Test
	public void obtenerCarroServicioPorvehiculoFactoryService() throws PreconditionException {
		// arrange
		vehiculo = new VehiculoTestDataBuilder().build();

		// act
		vehiculoService = vehiculoFactoryService.getService(vehiculo);

		// assert
		assertEquals(CarroServiceImpl.class, vehiculoService.getClass());
	}

	@Test
	public void obtenerMotoServicioPorVehiculoFactoryService() throws PreconditionException {
		// arrange
		vehiculo = new VehiculoTestDataBuilder().setPlaca("342-de").setTipoVehiculo("MOTO").build();

		// act
		vehiculoService = vehiculoFactoryService.getService(vehiculo);

		// assert
		assertEquals(MotoServiceImpl.class, vehiculoService.getClass());
	}

	@Test
	public void exceptionObtenerServicioPorTipoVehiculoNoExisteEnVehiculoFactoryService() throws PreconditionException {
		// arrange
		vehiculo = new VehiculoTestDataBuilder().setPlaca("342-de").setTipoVehiculo("AUTOBUS").build();

		try {
			// act
			vehiculoService = vehiculoFactoryService.getService(vehiculo);
		
		} catch (PreconditionException e) {
			
			System.out.println(e.getMessage());
			
			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_EXISTE, e.getMessage());
		}

	}

}
