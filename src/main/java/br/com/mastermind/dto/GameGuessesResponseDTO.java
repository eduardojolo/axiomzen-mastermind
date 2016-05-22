package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.List;

public class GameGuessesResponseDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 4906830335820798617L;

	private String winner;

	private List<PlayerGuessesDTO> playerGuesses;

	public GameGuessesResponseDTO() {
		super();
	}

	public GameGuessesResponseDTO(String winner, List<PlayerGuessesDTO> playerGuesses) {
		super();
		this.winner = winner;
		this.playerGuesses = playerGuesses;
	}

	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner
	 *            the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * @return the playerGuesses
	 */
	public List<PlayerGuessesDTO> getPlayerGuesses() {
		return playerGuesses;
	}

	/**
	 * @param playerGuesses
	 *            the playerGuesses to set
	 */
	public void setPlayerGuesses(List<PlayerGuessesDTO> playerGuesses) {
		this.playerGuesses = playerGuesses;
	}

}
