package br.com.mastermind.validator;

import java.util.List;

import br.com.mastermind.constants.MastermindConstants;
import br.com.mastermind.exceptions.InvalidPegColorCodeException;

/**
 * Validate if any of the given colors is invalid.
 * 
 * @author Eduardo Jolo
 *
 */
public class CodePegsColorValidator {
	
	/**
	 * Private constructor for utilitary class.
	 */
	private CodePegsColorValidator() {
	}

	/**
	 * Validate the all the pegs in the guesses code looking for invalid colors.
	 * 
	 * @param codePegs
	 *            Code pegs
	 */
	public static void validate(List<Character> codePegs) {
		for (Character peg : codePegs) {

			if (!MastermindConstants.COLORS.contains(peg)) {
				throw new InvalidPegColorCodeException(peg);
			}

		}

	}

}
