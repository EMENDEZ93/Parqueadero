package em.parqueadero.backend.domain.vigilante.parqueadero;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.ServicioParqueoSegunTipoVehiculo;
import em.parqueadero.backend.domain.vigilante.parqueadero.carro.ServicioParqueaderoTipoCarro;
import em.parqueadero.backend.domain.vigilante.parqueadero.moto.ServicioParqueaderoTipoMoto;

public class ServicioParqueoSegunTipoVehiculoTest {

	private ServicioParqueoSegunTipoVehiculo factory;

	@Before
	public void setUp() {
		factory = Mockito.spy(ServicioParqueoSegunTipoVehiculo.class);
	}

	@Test
	public void factorygetServiceMotoTest() throws PreconditionException {

		// arrange
		VehiculoDto moto = new VehiculoTestDataBuilder().setTipoVehiculo(CondicionesParqueaderoConstant.MOTO).buildModel();
		when(factory.getService(moto)).thenReturn(new ServicioParqueaderoTipoMoto());

		// act
		VigilanteService vehiculoService = factory.getService(moto);

		// assert
		assertTrue(vehiculoService instanceof ServicioParqueaderoTipoMoto);

	}

	@Test
	public void factorygetServiceCarroTest() throws PreconditionException {

		// arrange
		VehiculoDto carro = new VehiculoTestDataBuilder().buildModel();
		when(factory.getService(carro)).thenReturn(new ServicioParqueaderoTipoCarro());

		// act
		VigilanteService vehiculoService = factory.getService(carro);

		// assert
		assertTrue(vehiculoService instanceof ServicioParqueaderoTipoCarro);

	}

	@Test
	public void factorygetServiceNullTipoVehiculoTest() throws PreconditionException {

		// arrange
		VehiculoDto carro = new VehiculoTestDataBuilder().setTipoVehiculo("Camioneta").buildModel();
		
		try {
			
			// act
			when(factory.getService(carro)).thenThrow(new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE));
			
		} catch (PreconditionException e) {
			
			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_EXISTE, e.getMessage());
		
		}

	}

}
