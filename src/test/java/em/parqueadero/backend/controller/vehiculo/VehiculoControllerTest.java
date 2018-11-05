package em.parqueadero.backend.controller.vehiculo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehiculoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
	}

	@Test
	public void ingresoVehiculoTest() throws Exception {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().build();

		// act
		mockMvc.perform(
				post("/ingreso/vehiculo").contentType(MediaType.APPLICATION_JSON).content(ConverToJson(vehiculo)))

				// assert
				.andExpect(status().isOk()).andExpect(content().string(ConverToJson(vehiculo)));

	}

	@Test
	public void vehiculoPlacasNoValidaTest() throws Exception {

		// arrange
		VehiculoModel vehiculo = new VehiculoTestDataBuilder().setPlaca("").build();


			// act
			mockMvc.perform(
				post("/ingreso/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(ConverToJson(vehiculo))
				).andExpect(status().is5xxServerError());		
	
	
	}

	public static String ConverToJson(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
