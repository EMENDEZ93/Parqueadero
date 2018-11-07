package em.parqueadero.backend.persistence.builder.parqueadero;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.model.parqueadero.ParqueaderoTestDataBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.ParqueaderoBuilder;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.parqueadero.ParqueaderoModel;

public class ParqueaderoBuilderTest {

	@Test
	public void convertirParqueaderoEntityAModelTest() {

		// arrange
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoTestDataBuilder().buildEntity();

		// act
		ParqueaderoModel parqueaderoModel = ParqueaderoBuilder.convertirParqueaderoEntityAModel(parqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel instanceof ParqueaderoModel);

	}

	@Test
	public void convertirParqueaderoEntityAModelNullTest() {

		// arrange
		ParqueaderoEntity parqueaderoEntity = null;

		// act
		ParqueaderoModel parqueaderoModel = ParqueaderoBuilder.convertirParqueaderoEntityAModel(parqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel == null);

	}	
	
}
