package br.com.mastermind.dao;

import br.com.mastermind.dto.GameDTO;

public interface IGameDAO {

	/**
	 * Finds an existing game in the cache or database.
	 * 
	 * @param gameKey Game key
	 * @return the game
	 */
	public GameDTO findGame(String gameKey);
	
	/**
	 * Stores the game in the cache and database.
	 * 
	 * @param gameDTO the game
	 */
	void saveGame(GameDTO gameDTO);
}
