package em.parqueadero.backend.domain.vehiculo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.domain.vehiculo.factory.carro.CarroServiceImpl;
import em.parqueadero.backend.domain.vehiculo.factory.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@Service
public class Factory {

	@Autowired
	private MotoServiceImpl motoService;

	@Autowired
	private CarroServiceImpl carroService;

	public VehiculoService getService(VehiculoModel vehiculo) {
		
		switch (vehiculo.getTipoVehiculo()) {

		case VehiculoConstant.CARRO:
			return carroService;

		case VehiculoConstant.MOTO:
			return motoService;

		default:
			return null;
		}

	}

}
