package em.parqueadero.backend.domain.exception.preconditionexception;

public class PreconditionException extends Exception {

	private static final long serialVersionUID = 2478710386765464162L;
	private final String message;

	public PreconditionException(String message, Exception e) {
		super(e.getMessage(), e);
		this.message = message;
	}

	public PreconditionException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
