package em.parqueadero.backend.domain.vehiculo.factory.moto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.IsValid;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.LugarDisponibleParqueo;
import em.parqueadero.backend.model.vehiculo.Vehiculo;
import em.parqueadero.backend.repository.parqueadero.ParqueaderoJpaRepository;

@Service
public class MotoServiceImpl implements VehiculoService, LugarDisponibleParqueo, IsValid {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;
	
	@Override
	public boolean lugarDisponibleParqueo() throws PreconditionException {
		if(parqueaderoJpaRepository.findByTipoVehiculo(VehiculoConstant.MOTO).size() < VehiculoConstant.LIMITE_MOTOS_PARQUEADAS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_MOTO);
	}

	@Override
	public boolean isValid(Vehiculo vehiculo) throws PreconditionException {
		
		if(vehiculo.getPlaca().trim().equals("")) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}
		
		if(vehiculo.getTipoVehiculo().trim().equals("")) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);	
		}

		if(vehiculo.getCilindraje() == 0 ) {
			throw new PreconditionException(ConstantExcep.CILINDRAJE_NO_VALIDO);	
		}
		
		return true;

	}

}
