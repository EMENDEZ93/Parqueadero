package em.parqueadero.backend.domain.vigilante.tipovehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoModel;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.carro.CarroServiceImpl;
import em.parqueadero.backend.domain.vigilante.tipovehiculo.moto.MotoServiceImpl;

@Service
public class TipoVehiculoFactory { 

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
