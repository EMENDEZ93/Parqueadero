package em.parqueadero.backend.domain.factory.vehiculo.impl;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.factory.vehiculo.VehiculoFactoryService;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.impl.CarroServiceImpl;
import em.parqueadero.backend.domain.vehiculo.impl.MotoServiceImpl;
import em.parqueadero.backend.model.vehiculo.Vehiculo;

@Service("vehiculoFactoryService")
public class VehiculoFactoryServiceImpl implements VehiculoFactoryService {

	@Override													
	public VehiculoService getService(Vehiculo vehiculo) throws PreconditionException {
		
		switch (vehiculo.getTipoVehiculo()) {
		case "MOTO":
			return new MotoServiceImpl();

		case "CARRO":
			return new CarroServiceImpl();
		default:
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE);
		}
	}

}
