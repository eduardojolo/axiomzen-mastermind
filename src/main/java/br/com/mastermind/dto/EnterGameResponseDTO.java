package br.com.mastermind.dto;

import java.io.Serializable;

/**
 * Reponse for a new game created
 * 
 * @author Eduardo Jolo
 *
 */
public class EnterGameResponseDTO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 9017083729748858114L;

	private String playerKey;
	
	private String gameKey;

	public EnterGameResponseDTO() {
		super();
	}

	public EnterGameResponseDTO(String playerKey, String gameKey) {
		super();
		this.playerKey = playerKey;
		this.gameKey = gameKey;
	}

	/**
	 * @return the playerKey
	 */
	public String getPlayerKey() {
		return playerKey;
	}

	/**
	 * @param playerKey the playerKey to set
	 */
	public void setPlayerKey(String playerKey) {
		this.playerKey = playerKey;
	}

	/**
	 * @return the gameKey
	 */
	public String getGameKey() {
		return gameKey;
	}

	/**
	 * @param gameKey the gameKey to set
	 */
	public void setGameKey(String gameKey) {
		this.gameKey = gameKey;
	}
	
	
}
