package em.parqueadero.backend.domain.vehiculo.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryTest {

	@Autowired
	private Factory factory;

	@Before
	public void setUp() {
	}
	
	@Test
	public void factorygetServiceMotoTest() {
		
		// arrange
		VehiculoModel moto = new VehiculoTestDataBuilder().setTipoVehiculo(VehiculoConstant.MOTO).build();

		// act
		VehiculoService vehiculoService = factory.getService(moto);
		
		// assert
		assertTrue(vehiculoService instanceof MotoServiceImpl);
		
	}

}
