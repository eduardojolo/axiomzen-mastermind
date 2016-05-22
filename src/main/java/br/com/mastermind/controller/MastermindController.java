package br.com.mastermind.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastermind.dto.CreateGameRequestDTO;
import br.com.mastermind.dto.EnterGameResponseDTO;
import br.com.mastermind.dto.GameGuessesResponseDTO;
import br.com.mastermind.dto.GuessRequestDTO;
import br.com.mastermind.dto.GuessResponseDTO;
import br.com.mastermind.dto.JoinGameRequestDTO;
import br.com.mastermind.service.IGameService;
import br.com.mastermind.service.IGuessService;
import br.com.mastermind.validator.CodePegsColorValidator;

/**
 * Mastermind main controller that handles all the Rest requests.
 * 
 * @author Eduardo Jolo
 *
 */
@RestController
public class MastermindController {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IGuessService guessService;
	
	/**
	 * Creates a new game.
	 * Requires a user name and returns the game key and a player key, to used when submiting a guess.
	 * 
	 * @param createGameRequestDTO User name
	 * @return game key + player key
	 */
	@RequestMapping(value="/newgame", method= RequestMethod.POST, consumes="application/json")
	public EnterGameResponseDTO newGame(@Valid @RequestBody CreateGameRequestDTO createGameRequestDTO) {
		return gameService.newGame(createGameRequestDTO);
	}
	
	/**
	 * Joins an existing new game.
	 * Requires a user name and returns the game key and a player key, to used when submiting a guess.
	 * 
	 * @param joinGameRequestDTO Player name + game key
	 * @return game key + player key
	 */
	@RequestMapping(value="/joingame", method= RequestMethod.POST, consumes="application/json")
	public EnterGameResponseDTO joinGame(@RequestBody JoinGameRequestDTO joinGameRequestDTO) {
		return gameService.joinGame(joinGameRequestDTO);
	}
	
	/**
	 * Check if the guesses code matches the game generated code.
	 * 
	 * @param guessRequestDTO Guess information
	 * @return key pegs + true if guess is correct
	 */
	@RequestMapping(value="/guess", method= RequestMethod.POST, consumes="application/json")
	public GuessResponseDTO guess(@Valid @RequestBody GuessRequestDTO guessRequestDTO, BindingResult result) {
		CodePegsColorValidator.validate(guessRequestDTO.getGuessedCode());
		return guessService.guess(guessRequestDTO);
	}
	
	/**
	 * Gets a list of all the guesses mades by all the players in a game.
	 * 
	 * @param gameKey Game key
	 * @return List of guesses for a game
	 */
	@RequestMapping(value="/gameguesses", method= RequestMethod.GET)
	public GameGuessesResponseDTO getPlayerGuessesForGame(@RequestParam String gameKey) {
		return gameService.getPlayerGuessesForGame(gameKey);
	}
	
}
