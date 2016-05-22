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


	@NotNull
	private String playerName;
	
	private Integer numberOfPlayers;

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
	 * @return the numberOfPlayers
	 */
	public Integer getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(Integer numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
