package br.com.mastermind.dao;

import br.com.mastermind.dto.PlayerDTO;

/**
 * Interface for the methods that interact with the player entity.
 * 
 * @author Eduardo Jolo
 *
 */
public interface IPlayerDAO {

	/**
	 * Finds an existing player in the cache or database.
	 * 
	 * @param playerKey Player key
	 * @return the player
	 */
	public PlayerDTO findPlayer(String playerKey);
	
	/**
	 * Stores the player in the cache and database.
	 * 
	 * @param playerDTO the player
	 */
	void savePlayer(PlayerDTO playerDTO);
}
