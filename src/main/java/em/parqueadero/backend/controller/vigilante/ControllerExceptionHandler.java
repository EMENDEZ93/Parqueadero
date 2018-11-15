package em.parqueadero.backend.controller.vigilante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { PreconditionException.class})
	protected ResponseEntity<Object> preconditionException(PreconditionException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	
}
 