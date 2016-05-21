package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.List;

public class GuessRequestDTO implements Serializable {

	private String gameKey;
	
	private String playerKey;
	
	private List<Character> guessedCode;

	public GuessRequestDTO() {
		
	}
	
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
