package em.parqueadero.backend.domain.vehiculo.carro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.carro.CarroService;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.parqueadero.ParqueaderoJpaRepository;

@Service
public class CarroServiceImpl implements VehiculoService, CarroService {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;

	@Override
	public Vehiculo ingresoVehiculoParqueadero() {
		return null;
	}

	@Override
	public Vehiculo tipoVehiculo(Vehiculo vehiculo) throws PreconditionException {
		return null;
	}

	@Override
	public boolean disponibilidadParqueoCarro() {
		return (parqueaderoJpaRepository.findByTipoVehiculo(VehiculoConstant.CARRO)
				.size() < VehiculoConstant.LIMITE_CARROS_PARQUEADOS);
	}

}
