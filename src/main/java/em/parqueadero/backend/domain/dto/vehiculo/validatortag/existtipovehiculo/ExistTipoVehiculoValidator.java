package em.parqueadero.backend.domain.dto.vehiculo.validatortag.existtipovehiculo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import em.parqueadero.backend.domain.constant.condition.CondicionesParqueaderoConstant;

public class ExistTipoVehiculoValidator implements ConstraintValidator<ExistTipoVehiculo, String> {

	@Override
	public boolean isValid(String tipoVehiculo, ConstraintValidatorContext context) {

		if (tipoVehiculo == null)
			return false;

		return (tipoVehiculo.equals(CondicionesParqueaderoConstant.CARRO)
				|| tipoVehiculo.equals(CondicionesParqueaderoConstant.MOTO));
	}

}
