package br.com.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MastermindGenericException extends RuntimeException {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -5989956677305812864L;
	
	/**
	 * Exception message.
	 */
	private static final String EXCEPTION_MESSAGE = "An internal error happened! Please, try again later.";
	
	/**
	 * Default constructor.
	 */
	public MastermindGenericException() {
		super(EXCEPTION_MESSAGE);
	}
}
