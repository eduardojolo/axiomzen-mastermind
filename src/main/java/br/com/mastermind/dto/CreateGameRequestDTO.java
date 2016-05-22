package br.com.mastermind.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Request DTO for creating a new game.
 * 
 * @author Eduardo Jolo
 *
 */
public class CreateGameRequestDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -288574738791120749L;

	@NotNull
	private String playerName;

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

}
