package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request object for a guess.
 * 
 * @author Eduardo Jolo
 *
 */
public class GuessRequestDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -6968003381041555165L;

	@NotNull
	private String gameKey;
	
	@NotNull
	private String playerKey;
	
	@NotNull
	@Size(min=8, max=8)
	private List<Character> guessedCode;

	/**
	 * Default constructor.
	 */
	public GuessRequestDTO() {
		super();
	}
	
	/**
	 * Composed constructor.
	 * 
	 * @param gameKey Game key
	 * @param playerKey Player key
	 * @param guessedCode Guessed code
	 */
	public GuessRequestDTO(String gameKey, String playerKey, List<Character> guessedCode) {
		super();
		this.gameKey = gameKey;
		this.playerKey = playerKey;
		this.guessedCode = guessedCode;
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
	 * @return the guessedCode
	 */
	public List<Character> getGuessedCode() {
		return guessedCode;
	}

	/**
	 * @param guessedCode the guessedCode to set
	 */
	public void setGuessedCode(List<Character> guessedCode) {
		this.guessedCode = guessedCode;
	}
	
}
