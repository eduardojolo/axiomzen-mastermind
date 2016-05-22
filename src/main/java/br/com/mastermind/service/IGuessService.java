package br.com.mastermind.service;

import br.com.mastermind.dto.GuessRequestDTO;
import br.com.mastermind.dto.GuessResponseDTO;

/**
 * Interface of the methods that access the guesses information.
 * 
 * @author Eduardo Jolo
 *
 */
public interface IGuessService {

	/**
	 * Register a new guess in a game.
	 * 
	 * @param guessRequestDTO Guess data.
	 * @return Check result
	 */
	GuessResponseDTO guess(GuessRequestDTO guessRequestDTO);
}
