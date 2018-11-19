package em.parqueadero.backend.controller.vigilante;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VigilanteControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private VigilanteController vigilanteController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(vigilanteController).build();
	}

	@Test
	public void registroIngresoCarroParqueaderoTest() throws Exception {

		VehiculoDto vehiculo = new VehiculoDto();
		vehiculo.setCilindraje(800);
		vehiculo.setPlaca("XVV808");
		vehiculo.setTipoVehiculo("Moto");

		mockMvc.perform(post("/registro/ingreso/vehiculo/parqueadero").contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(vehiculo))).andExpect(status().isOk());
	}

	public String convertToJson(VehiculoDto vehiculo) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(vehiculo);
	}

}
