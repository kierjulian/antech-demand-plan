package ph.edu.ph.antech.exception;

public class DifferentProductException extends RuntimeException {

	public DifferentProductException() {
		super();
	}

	public DifferentProductException(String message) {
		super(message);
	}

	public DifferentProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public DifferentProductException(Throwable cause) {
		super(cause);
	}

	protected DifferentProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
