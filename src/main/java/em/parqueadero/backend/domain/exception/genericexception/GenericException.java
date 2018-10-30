package em.parqueadero.backend.domain.exception.genericexception;

public class GenericException extends Exception {

	private static final long serialVersionUID = 3613364874967438255L;
	private final String message;

	public GenericException(String message, Exception e) {
		super(e.getMessage(), e);
		this.message = message;
	}

	public GenericException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}	
	
}
