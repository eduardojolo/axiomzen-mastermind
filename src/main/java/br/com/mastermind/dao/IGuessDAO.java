package br.com.mastermind.dao;

import java.util.Map;

import br.com.mastermind.dto.PlayerGuessesDTO;

/**
 * Interface for the methods that interact with the guess entity.
 * 
 * @author Eduardo Jolo
 *
 */
public interface IGuessDAO {

	/**
	 * Finds the guesses made by eache player in a game.
	 * 
	 * @param gameKey Game key
	 * @return the game guesses for each player
	 */
	public Map<String, PlayerGuessesDTO> findGuesses(String gameKey);
	
	/**
	 * Stores all player's guesses for a game.
	 * 
	 * @param gameKey Game key
	 * @param guesses list of guesses of each player
	 */
	void saveGuesses(String gameKey, Map<String, PlayerGuessesDTO> guesses);
}
