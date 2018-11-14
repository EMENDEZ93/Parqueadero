package em.parqueadero.backend.persistence.builder.tipovehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.TipoVehiculoTestDataBuilder;
import em.parqueadero.backend.domain.dto.tipovehiculo.TipoVehiculoModel;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.persistence.builder.vehiculo.TipoVehiculoBuilder;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TarifaTipoVehiculoEntity;

public class TipoVehiculoBuilderTest {

	@Test
	public void convertirTipoVehiculoEntityAModelTest() {

		// arrange
		TarifaTipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoTestDataBuilder().buildEntity(); 
		TipoVehiculoModel tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = TipoVehiculoBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel instanceof TipoVehiculoModel);
	}
	
	@Test
	public void convertirTipoVehiculoEntityAModelNullTest() {

		// arrange
		TarifaTipoVehiculoEntity tipoVehiculoEntity = null; 
		TipoVehiculoModel tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = TipoVehiculoBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel == null);
	}

}
