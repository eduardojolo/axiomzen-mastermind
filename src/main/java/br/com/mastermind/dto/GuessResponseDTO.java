package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Response for a player guess. Contains the key pegs.
 * 
 * @author Eduardo Jolo
 *
 */
public class GuessResponseDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 2490488093514719366L;

	private boolean correctCode;

	private List<Character> keyPegs;
	
	private boolean gameHasAWinner;

	public GuessResponseDTO() {
		super();
	}

	public GuessResponseDTO(boolean correctCode, List<Character> keyPegs) {
		super();
		this.correctCode = correctCode;
		this.keyPegs = keyPegs;
	}

	/**
	 * @return the correctCode
	 */
	public boolean isCorrectCode() {
		return correctCode;
	}

	/**
	 * @param correctCode
	 *            the correctCode to set
	 */
	public void setCorrectCode(boolean correctCode) {
		this.correctCode = correctCode;
	}

	/**
	 * @return the keyPegs
	 */
	public List<Character> getKeyPegs() {
		return keyPegs;
	}

	/**
	 * @param keyPegs
	 *            the keyPegs to set
	 */
	public void setKeyPegs(List<Character> keyPegs) {
		this.keyPegs = keyPegs;
	}

	/**
	 * @return the gameHasAWinner
	 */
	public boolean isGameHasAWinner() {
		return gameHasAWinner;
	}

	/**
	 * @param gameHasAWinner the gameHasAWinner to set
	 */
	public void setGameHasAWinner(boolean gameHasAWinner) {
		this.gameHasAWinner = gameHasAWinner;
	}

}
