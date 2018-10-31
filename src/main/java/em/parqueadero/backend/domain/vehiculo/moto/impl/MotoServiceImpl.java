package em.parqueadero.backend.domain.vehiculo.moto.impl;

import org.springframework.beans.factory.annotation.Autowired;

import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.moto.MotoServicio;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.parqueadero.ParqueaderoJpaRepository;

public class MotoServiceImpl implements VehiculoService, MotoServicio {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) {
		ingresoVehiculoParqueadero();
		return vehiculo;
	}

	@Override
	public Vehiculo ingresoVehiculoParqueadero() {
		return null;
	}

	@Override
	public boolean disponibilidadParqueoMoto() {
		return (parqueaderoJpaRepository.
				findByTipoVehiculo(VehiculoConstant.MOTO).size() < VehiculoConstant.LIMITE_MOTOS_PARQUEADAS);
	}

}
