package br.com.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be used in case the game is waiting for other players to join.
 * 
 * @author Eduardo Jolo
 *
 */
@ResponseStatus(value = HttpStatus.PRECONDITION_REQUIRED)
public class WaitingForPlayersException extends RuntimeException {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 5725827062882174282L;
	
	/**
	 * Exception message.
	 */
	private static final String EXCEPTION_MESSAGE = "Waiting for other players to connect do this game, try again later. Number of pending players: ";

	/**
	 * Composed constructor.
	 * 
	 * @param numberOfPendingPlayers
	 *            Number of pending players
	 */
	public WaitingForPlayersException(Integer numberOfPendingPlayers) {
		super(EXCEPTION_MESSAGE + numberOfPendingPlayers);
	}
}
