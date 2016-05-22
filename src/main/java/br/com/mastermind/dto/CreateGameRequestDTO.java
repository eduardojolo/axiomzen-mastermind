package br.com.mastermind.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CreateGameRequestDTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -288574738791120749L;
	
	@NotNull
	private String userName;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
