package em.parqueadero.backend.domain.vigilante.parqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.carro.ServicioParqueaderoTipoCarro;
import em.parqueadero.backend.domain.vigilante.parqueadero.moto.ServicioParqueaderoTipoMoto;

@Service
public class TipoVehiculoFactory { 

	@Autowired
	private ServicioParqueaderoTipoMoto servicioParqueaderoTipoMoto;

	@Autowired
	private ServicioParqueaderoTipoCarro servicioParqueaderoTipoCarro;

	public VigilanteService getService(VehiculoDto vehiculo) throws PreconditionException {
		
		switch (vehiculo.getTipoVehiculo()) {

		case VehiculoConstant.CARRO:
			return servicioParqueaderoTipoCarro;

		case VehiculoConstant.MOTO:
			return servicioParqueaderoTipoMoto;

		default:
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_EXISTE);
		}

	}

}
