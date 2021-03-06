package br.com.mastermind.service;

import br.com.mastermind.dto.CreateGameRequestDTO;
import br.com.mastermind.dto.EnterGameResponseDTO;
import br.com.mastermind.dto.GameDTO;
import br.com.mastermind.dto.GameGuessesResponseDTO;
import br.com.mastermind.dto.JoinGameRequestDTO;

/**
 * Interface of the methods that access the game info.
 * 
 * @author Eduardo Jolo
 *
 */
public interface IGameService {

	/**
	 * Create new game.
	 * 
	 * @param createGameRequestDTO
	 *            Info to create the new game
	 * @return Game data
	 */
	EnterGameResponseDTO newGame(CreateGameRequestDTO createGameRequestDTO);

	/**
	 * Generates a new playerKey in a game.
	 * 
	 * @param joinGameRequestDTO
	 *            Join game data
	 * @return game key = player key
	 */
	EnterGameResponseDTO joinGame(JoinGameRequestDTO joinGameRequestDTO);

	/**
	 * Get all the guesses made by all the users playing the game with the given
	 * key.
	 * 
	 * @param gameKey
	 *            Game key
	 * @return Guesses data
	 */
	GameGuessesResponseDTO getPlayerGuessesForGame(String gameKey);

	/**
	 * Set the winner of a game if no other was set before.
	 * 
	 * @param gameKey
	 *            Game key
	 * @param playerName
	 *            Winner
	 */
	void updateWinner(String gameKey, String playerName);

	/**
	 * Gets a game by its key.
	 * 
	 * @param gameKey Game key
	 * @return Game
	 */
	GameDTO getGame(String gameKey);

}
