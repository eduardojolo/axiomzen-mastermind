package br.com.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoPlayerWasFoundException extends RuntimeException {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -6573588366505159991L;
	
	/**
	 * Exception message.
	 */
	private static final String EXCEPTION_MESSAGE = "No player was found with the key: ";
	
	/**
	 * Composed constructor.
	 * 
	 * @param playerKey Player key
	 */
	public NoPlayerWasFoundException(String playerKey) {
		super(EXCEPTION_MESSAGE + playerKey);
	}
}
