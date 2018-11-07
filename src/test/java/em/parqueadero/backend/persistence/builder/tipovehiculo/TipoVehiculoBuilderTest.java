package em.parqueadero.backend.persistence.builder.tipovehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.TipoVehiculoTestDataBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.TipoVehiculoBuilder;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.persistence.model.tipovehiculo.TipoVehiculoModel;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

public class TipoVehiculoBuilderTest {

	@Test
	public void convertirTipoVehiculoEntityAModelTest() {

		// arrange
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoTestDataBuilder().buildEntity(); 
		TipoVehiculoModel tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = TipoVehiculoBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel instanceof TipoVehiculoModel);
	}
	
	@Test
	public void convertirTipoVehiculoEntityAModelNullTest() {

		// arrange
		TipoVehiculoEntity tipoVehiculoEntity = null; 
		TipoVehiculoModel tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = TipoVehiculoBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel == null);
	}

}
