package em.parqueadero.backend.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.TipoVehiculoTestDataBuilder;
import em.parqueadero.backend.persistence.builder.vehiculo.TipoVehiculoBuilder;
import em.parqueadero.backend.persistence.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.persistence.model.tipovehiculo.TipoVehiculoModel;
import em.parqueadero.backend.persistence.repository.tipovehiculo.TipoVehiculoJpaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehiculoTest {

	@Autowired
	@Qualifier("tipoVehiculoJpaRepository")
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;
	
	private TipoVehiculoBuilder tipoVehiculoBuilder;
	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder;
	private TipoVehiculoModel tipoVehiculoModel;

	@Before
	public void setUp() throws Exception {

		tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
		tipoVehiculoModel = tipoVehiculoTestDataBuilder.build();

		TipoVehiculoEntity tipoVehiculoEntity2 = new TipoVehiculoEntity();
		tipoVehiculoEntity2.setIdTipoVehiculo(1);
		tipoVehiculoEntity2.setNombre("Carro");

		tipoVehiculoJpaRepository.save(tipoVehiculoBuilder.convertirTipoVehiculoModelAEntity(tipoVehiculoModel));

	}

	@Test
	public void test() {
		TipoVehiculoEntity tipoVehiculoEntity = tipoVehiculoJpaRepository.getOne(2);
		assertThat(tipoVehiculoEntity.getNombre()).isEqualTo("Carro");
	}

}
