package br.com.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Mastermind exception for an invalid color peg.
 * 
 * @author Eduardo Jolo
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidPegColorCodeException extends RuntimeException {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -5989956677305812864L;
	
	/**
	 * Exception message.
	 */
	private static final String EXCEPTION_MESSAGE = "Invalid peg color: ";
	
	/**
	 * Default constructor.
	 * 
	 * @param colorCode Color code
	 */
	public InvalidPegColorCodeException(Character colorCode) {
		super(EXCEPTION_MESSAGE + colorCode);
	}
}
