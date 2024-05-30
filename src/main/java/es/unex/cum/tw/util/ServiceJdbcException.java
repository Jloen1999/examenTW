package es.unex.cum.tw.util;

public class ServiceJdbcException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceJdbcException(String message) {
        super(message);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
