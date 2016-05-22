package br.com.mastermind.dto;

import java.io.Serializable;

/**
 * Error response DTO for better exception handling.
 * 
 * @author Eduardo
 *
 */
public class ErrorResponseDTO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 8410659124213789358L;
	
	private String message;
	
	/**
	 * Composed constructor.
	 * 
	 * @param message Message
	 */
	public ErrorResponseDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
