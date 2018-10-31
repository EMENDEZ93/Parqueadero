package em.parqueadero.backend.domain.vehiculo.moto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.moto.DisponibilidadParqueoMoto;
import em.parqueadero.backend.domain.vehiculo.segregation.Delete;
import em.parqueadero.backend.domain.vehiculo.segregation.Save;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.tipovehiculo.TipoVehiculoJpaRepository;

public class MotoServiceImpl implements VehiculoService, Save, Delete, DisponibilidadParqueoMoto {

	@Autowired
	@Qualifier("tipoVehiculoJpaRepository")
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;
	
	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) {
		System.out.println(moto());
		save();
		return vehiculo;
	}

	@Override
	public Vehiculo save() {
		
		if(!disponibilidadParqueoMoto()) {
			System.out.println("*******************************");
			System.out.println("No hay Disponibilidad Para Motos");
		}
		
		return null;
	}

	public String moto() {
		return "MOTO";
	}
	
	@Override
	public void delete(Vehiculo vehiculo) {
		
	}

	@Override
	public boolean disponibilidadParqueoMoto() {
		return false;
	}

}
