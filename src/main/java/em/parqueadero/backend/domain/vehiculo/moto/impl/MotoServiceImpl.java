package em.parqueadero.backend.domain.vehiculo.moto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.segregation.Save;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.tipovehiculo.TipoVehiculoJpaRepository;

public class MotoServiceImpl implements VehiculoService, Save {

	@Autowired
	@Qualifier("tipoVehiculoJpaRepository")
	private TipoVehiculoJpaRepository tipoVehiculoJpaRepository;
	
	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) {
		return vehiculo;
	}

	@Override
	public Vehiculo save() {
		return null;
	}

}
