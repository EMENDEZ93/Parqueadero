package em.parqueadero.backend.domain.vehiculo.factory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.factory.Factory;
import em.parqueadero.backend.domain.vigilante.factory.carro.CarroServiceImpl;
import em.parqueadero.backend.domain.vigilante.factory.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public class FactoryTest {

	private Factory factory;

	@Before
	public void setUp() {
		factory = Mockito.spy(Factory.class);
	}

	@Test
	public void factorygetServiceMotoTest() throws PreconditionException {

		// arrange
		VehiculoModel moto = new VehiculoTestDataBuilder().setTipoVehiculo(VehiculoConstant.MOTO).buildModel();
		when(factory.getService(moto)).thenReturn(new MotoServiceImpl());

		// act
		VigilanteService vehiculoService = factory.getService(moto);

		// assert
		assertTrue(vehiculoService instanceof MotoServiceImpl);

	}

	@Test
	public void factorygetServiceCarroTest() throws PreconditionException {

		// arrange
		VehiculoModel carro = new VehiculoTestDataBuilder().buildModel();
		when(factory.getService(carro)).thenReturn(new CarroServiceImpl());

		// act
		VigilanteService vehiculoService = factory.getService(carro);

		// assert
		assertTrue(vehiculoService instanceof CarroServiceImpl);

	}

	@Test
	public void factorygetServiceNullTipoVehiculoTest() throws PreconditionException {

		// arrange
		VehiculoModel carro = new VehiculoTestDataBuilder().setTipoVehiculo("Camioneta").buildModel();
		
		try {
			
			// act
			when(factory.getService(carro)).thenThrow(new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE));
			
		} catch (PreconditionException e) {
			
			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_EXISTE, e.getMessage());
		
		}

	}

}
