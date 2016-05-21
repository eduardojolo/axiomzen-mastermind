package br.com.mastermind.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Mastermind constants static class.
 * 
 * @author Eduardo Jolo
 *
 */
public final class MastermindConstants {

	/**
	 * Mastermind available colors.
	 * R: red
	 * B: blue
	 * G: green
	 * P: pink
	 * Y: yellow
	 * O: orange
	 * V: violet
	 * M: magenta
	 */
	public static final List<Character> COLORS = Arrays.asList('R', 'B', 'G', 'P', 'Y', 'O', 'V', 'M');
	
	/**
	 * Key peg that indicates a correct color and position.
	 */
	public static final Character BLACK_KEY_PEG = 'B';
	
	/**
	 * Key peg that indicates a correct color in the wrong position.
	 */
	public static final Character WHITE_KEY_PEG = 'W';
	
	/**
	 * Number of different colors available.
	 */
	public static final Integer NUMBER_OF_COLORS = 8;
	
	/**
	 * Number of positions in the code and guesses.
	 */
	public static final Integer NUMBER_OF_POSITIONS = 8;
	
	/**
	 * Private contructor for static class.
	 */
	private MastermindConstants() {
	}
}
