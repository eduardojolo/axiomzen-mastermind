package br.com.mastermind.dto;

import java.io.Serializable;

public class PlayerDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -1560614907869188512L;

	private String playerKey;
	
	private String playerName;

	public PlayerDTO() {
		super();
	}

	public PlayerDTO(String playerKey, String playerName) {
		super();
		this.playerKey = playerKey;
		this.playerName = playerName;
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
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
