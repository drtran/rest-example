package gov.dhs.nppd.restexample.service.exception;

public class BookAlreadyExistsException extends Exception {

	private String message;

	public BookAlreadyExistsException(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
