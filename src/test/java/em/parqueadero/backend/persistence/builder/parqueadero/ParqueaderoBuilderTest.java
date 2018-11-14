package em.parqueadero.backend.persistence.builder.parqueadero;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.model.parqueadero.ParqueaderoTestDataBuilder;
import em.parqueadero.backend.domain.dto.parqueadero.ParqueaderoModel;
import em.parqueadero.backend.persistence.builder.vehiculo.ParqueaderoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public class ParqueaderoBuilderTest {

	@Test
	public void convertirParqueaderoEntityAModelTest() {

		// arrange
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new ParqueaderoTestDataBuilder().buildEntity();

		// act
		ParqueaderoModel parqueaderoModel = ParqueaderoBuilder.convertirParqueaderoEntityAModel(registroVehiculoParqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel instanceof ParqueaderoModel);

	}

	@Test
	public void convertirParqueaderoEntityAModelNullTest() {

		// arrange
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = null;

		// act
		ParqueaderoModel parqueaderoModel = ParqueaderoBuilder.convertirParqueaderoEntityAModel(registroVehiculoParqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel == null);

	}	
	
}
