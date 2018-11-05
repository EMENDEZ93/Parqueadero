package em.parqueadero.backend.domain.vehiculo.factory.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.IsValid;
import em.parqueadero.backend.domain.vehiculo.factory.segregration.LugarDisponibleParqueo;
import em.parqueadero.backend.persistence.model.vehiculo.Vehiculo;
import em.parqueadero.backend.persistence.repository.parqueadero.ParqueaderoJpaRepository;

@Service
public class CarroServiceImpl implements VehiculoService, LugarDisponibleParqueo, IsValid {

	@Autowired
	private ParqueaderoJpaRepository parqueaderoJpaRepository;
	
	@Override
	public boolean lugarDisponibleParqueo() throws PreconditionException {
		if(parqueaderoJpaRepository.findByTipoVehiculo(VehiculoConstant.CARRO).size() < VehiculoConstant.LIMITE_CARROS_PARQUEADOS) {
			return true;
		}
		throw new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO);
	}

	@Override
	public boolean isValid(Vehiculo vehiculo) throws PreconditionException {
		
		if(vehiculo.getPlaca().trim().equals("")) {
			throw new PreconditionException(ConstantExcep.PLACA_NO_VALIDA);
		}
		
		if(vehiculo.getTipoVehiculo().trim().equals("")) {
			throw new PreconditionException(ConstantExcep.TIPO_VEHICULO_NO_VALIDO);	
		}
		
		return true;
	}

	@Override
	public Vehiculo ingresoVehiculoParqueadero(Vehiculo vehiculo) throws PreconditionException {
		isValid(vehiculo);
		lugarDisponibleParqueo();
		return vehiculo;
	}

}
