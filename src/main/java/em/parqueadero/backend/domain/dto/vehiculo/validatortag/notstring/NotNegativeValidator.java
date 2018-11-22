package em.parqueadero.backend.domain.dto.vehiculo.validatortag.notstring;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNegativeValidator implements ConstraintValidator<NotNegative, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return (value >= 0);
	}

}
