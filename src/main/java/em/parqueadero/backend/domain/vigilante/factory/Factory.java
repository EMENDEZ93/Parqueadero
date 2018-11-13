package em.parqueadero.backend.domain.vigilante.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.factory.carro.CarroServiceImpl;
import em.parqueadero.backend.domain.vigilante.factory.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@Service
public class Factory { 

	@Autowired
	private MotoServiceImpl motoService;

	@Autowired
	private CarroServiceImpl carroService;

	public VigilanteService getService(VehiculoModel vehiculo) throws PreconditionException {
		
		switch (vehiculo.getTipoVehiculo()) {

		case VehiculoConstant.CARRO:
			return carroService;

		case VehiculoConstant.MOTO:
			return motoService;

		default:
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE);
		}

	}

}