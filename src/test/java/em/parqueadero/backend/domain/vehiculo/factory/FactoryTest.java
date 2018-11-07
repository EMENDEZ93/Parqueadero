package em.parqueadero.backend.domain.vehiculo.factory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public class FactoryTest {

	private Factory factory;

	@Before
	public void setUp() {
		factory = Mockito.spy(Factory.class);
	}
	
	@Test
	public void factorygetServiceMotoTest() {
		
		// arrange
		VehiculoModel moto = new VehiculoTestDataBuilder().setTipoVehiculo(VehiculoConstant.MOTO).build();
		when( factory.getService(moto) ).thenReturn( new MotoServiceImpl() );
		
		// act
		VehiculoService vehiculoService = factory.getService(moto);
		
		// assert
		assertTrue(vehiculoService instanceof MotoServiceImpl);
		
	}

}
