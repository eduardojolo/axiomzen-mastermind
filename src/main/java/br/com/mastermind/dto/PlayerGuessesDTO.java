package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the guesses made by a player in a game.
 * 
 * @author Eduardo Jolo
 *
 */
public class PlayerGuessesDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -3625160429390749570L;

	private String playerName;

	private List<List<Character>> guesses;

	public PlayerGuessesDTO() {
		super();
		guesses = new ArrayList<>();
	}

	public PlayerGuessesDTO(String playerName) {
		super();
		this.playerName = playerName;
		guesses = new ArrayList<>();
	}

	public PlayerGuessesDTO(String playerName, List<List<Character>> guesses) {
		super();
		this.playerName = playerName;
		this.guesses = guesses;
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
	 * @return the guesses
	 */
	public List<List<Character>> getGuesses() {
		return guesses;
	}

	/**
	 * @param guesses
	 *            the guesses to set
	 */
	public void setGuesses(List<List<Character>> guesses) {
		this.guesses = guesses;
	}

}
