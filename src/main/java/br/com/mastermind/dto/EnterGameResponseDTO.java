package br.com.mastermind.dto;

import java.io.Serializable;

/**
 * Reponse for entering a game.
 * 
 * @author Eduardo Jolo
 *
 */
public class EnterGameResponseDTO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 9017083729748858114L;

	private String gameKey;

	private String playerKey;

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
	 * @param playerKey
	 *            the playerKey to set
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
	 * @param gameKey
	 *            the gameKey to set
	 */
	public void setGameKey(String gameKey) {
		this.gameKey = gameKey;
	}

}
