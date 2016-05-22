package br.com.mastermind.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class GameDTO implements Serializable {

	private String gameKey;

	private List<Character> code;

	private Long startTime;

	private Set<Character> codeColors;
	
	private String winner;

	public GameDTO() {
		super();
	}
	
	public GameDTO(String gameKey, List<Character> code, Long startTime, Set<Character> codeColors) {
		super();
		this.gameKey = gameKey;
		this.code = code;
		this.startTime = startTime;
		this.codeColors = codeColors;
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

	/**
	 * @return the code
	 */
	public List<Character> getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(List<Character> code) {
		this.code = code;
	}

	/**
	 * @return the startTime
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the codeColors
	 */
	public Set<Character> getCodeColors() {
		return codeColors;
	}

	/**
	 * @param codeColors
	 *            the codeColors to set
	 */
	public void setCodeColors(Set<Character> codeColors) {
		this.codeColors = codeColors;
	}

	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

}
