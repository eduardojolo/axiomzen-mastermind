package br.com.mastermind.service;

import br.com.mastermind.dto.PlayerDTO;

/**
 * Interface of the methods that access the players information.
 * 
 * @author Eduardo Jolo
 *
 */
public interface IPlayerService {

	/**
	 * Get the player with the given key.
	 * 
	 * @param playerKey Player key
	 * @return Player
	 */
	PlayerDTO getPlayer(String playerKey);
	
	/**
	 * Save the player.
	 * 
	 * @param playerDTO Player data
	 */
	void savePlayer(PlayerDTO playerDTO);
}
