package exception;

public class LispException extends Exception {
	
	/**
	 * Don't really know what it is used for.
	 * IDE would shout out if not there. 
	 * To modify
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with message
	 * @param message
	 */
	public LispException(String message) {
        super(message);
    }
	
}
