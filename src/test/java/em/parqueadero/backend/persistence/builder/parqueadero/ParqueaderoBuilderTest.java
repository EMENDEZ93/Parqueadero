package em.parqueadero.backend.persistence.builder.parqueadero;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.model.parqueadero.ParqueaderoTestDataBuilder;
import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.VehiculosParqueadosDto;
import em.parqueadero.backend.persistence.builder.vehiculo.RegistroVehiculoParqueaderoBuilder;
import em.parqueadero.backend.persistence.entity.registrovehiculoparqueadero.RegistroVehiculoParqueaderoEntity;

public class ParqueaderoBuilderTest {

	@Test
	public void convertirParqueaderoEntityAModelTest() {

		// arrange
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new ParqueaderoTestDataBuilder().buildEntity();

		// act
		VehiculosParqueadosDto parqueaderoModel = RegistroVehiculoParqueaderoBuilder.convertirParqueaderoEntityADto(registroVehiculoParqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel instanceof VehiculosParqueadosDto);

	}

	@Test
	public void convertirParqueaderoEntityAModelNullTest() {

		// arrange
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = null;

		// act
		VehiculosParqueadosDto parqueaderoModel = RegistroVehiculoParqueaderoBuilder.convertirParqueaderoEntityADto(registroVehiculoParqueaderoEntity);

		// assert
		assertTrue(parqueaderoModel == null);

	}	
	
}
