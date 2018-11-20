package em.parqueadero.backend.persistence.builder.tipovehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.TipoVehiculoTestDataBuilder;
import em.parqueadero.backend.domain.dto.precios.PreciosDto;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.persistence.builder.vehiculo.PreciosBuilder;
import em.parqueadero.backend.persistence.entity.precios.PreciosEntity;

public class TipoVehiculoBuilderTest {

	@Test
	public void convertirTipoVehiculoEntityAModelTest() {

		// arrange
		PreciosEntity tipoVehiculoEntity = new TipoVehiculoTestDataBuilder().buildEntity(); 
		PreciosDto tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = PreciosBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel instanceof PreciosDto);
	}
	
	@Test
	public void convertirTipoVehiculoEntityAModelNullTest() {

		// arrange
		PreciosEntity tipoVehiculoEntity = null; 
		PreciosDto tipoVehiculoModel = null;
		
		// act
		tipoVehiculoModel = PreciosBuilder.convertirTipoVehiculoEntityAModel(tipoVehiculoEntity); 
		
		// assert
		assertTrue(tipoVehiculoModel == null);
	}

}
