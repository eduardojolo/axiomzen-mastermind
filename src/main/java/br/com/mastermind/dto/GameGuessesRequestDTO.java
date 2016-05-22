package br.com.mastermind.dto;

import java.io.Serializable;

public class GameGuessesRequestDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -9120503805917731175L;
	
	private String gameKey;

	public GameGuessesRequestDTO() {
		super();
	}

	public GameGuessesRequestDTO(String gameKey) {
		super();
		this.gameKey = gameKey;
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
