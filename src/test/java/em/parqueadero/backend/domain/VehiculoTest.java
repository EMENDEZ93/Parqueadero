package em.parqueadero.backend.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.entity.tipovehiculo.TipoVehiculoEntity;
import em.parqueadero.backend.repository.tipovehiculo.TipoVehiculoJpaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehiculoTest {

	@Autowired
	@Qualifier("tipoVehiculoJpaRepository")
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;
	
	@Before
	public void setUp() throws Exception {		
		TipoVehiculoEntity tipoVehiculoEntity2 = new TipoVehiculoEntity();
		tipoVehiculoEntity2.setIdTipoVehiculo(1);
		tipoVehiculoEntity2.setNombre("Carro");
		tipoVehiculoJpaRepository.save(tipoVehiculoEntity2);
	}
	
	
	@Test
	public void test() {
				
		TipoVehiculoEntity tipoVehiculoEntity =  tipoVehiculoJpaRepository.getOne(1);
		
		System.out.println("******************");
		System.out.println(tipoVehiculoEntity.getNombre());
		
	    assertThat(tipoVehiculoEntity.getNombre())
	      .isEqualTo("Carro");
		
	}

}
