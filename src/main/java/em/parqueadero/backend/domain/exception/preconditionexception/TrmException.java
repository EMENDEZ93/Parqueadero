package em.parqueadero.backend.domain.exception.preconditionexception;

public class TrmException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message;

	public TrmException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
