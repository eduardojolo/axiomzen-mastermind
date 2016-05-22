package br.com.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excption to be used in case the given game key does not relate to any of the known games.
 * 
 * @author Eduardo Jolo
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoGameWasFoundException extends RuntimeException {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -6573588366505159991L;
	
	/**
	 * Exception message.
	 */
	private static final String EXCEPTION_MESSAGE = "No game was found with the key: ";
	
	/**
	 * Composed constructor.
	 * 
	 * @param gameKey Game key
	 */
	public NoGameWasFoundException(String gameKey) {
		super(EXCEPTION_MESSAGE + gameKey);
	}
}
