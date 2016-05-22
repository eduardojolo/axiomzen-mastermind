package br.com.mastermind.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Request to join an existing game.
 * 
 * @author Eduardo Jolo
 *
 */
public class JoinGameRequestDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -5433015569579498207L;

	@NotNull
	private String playerName;

	@NotNull
	private String gameKey;

	public JoinGameRequestDTO() {
		super();
	}

	public JoinGameRequestDTO(String playerName, String gameKey) {
		super();
		this.playerName = playerName;
		this.gameKey = gameKey;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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
