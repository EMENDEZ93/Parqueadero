package em.parqueadero.backend.domain.dto.vehiculo.validacion.uniqueplaca;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import em.parqueadero.backend.persistence.repository.registrovehiculoparqueadero.RegistroVehiculoParqueaderoJpaRepository;

public class NotBeingParkedValidator implements ConstraintValidator<NotBeingParked, String> {

	@Autowired
	private RegistroVehiculoParqueaderoJpaRepository registroVehiculoParqueaderoJpaRepository;
	
	@Override
	public boolean isValid(String placa, ConstraintValidatorContext context) {
		return registroVehiculoParqueaderoJpaRepository.existsByParqueadoJoinPlaca(placa).isEmpty();
	}

}
