package br.com.mastermind.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mastermind.constants.MastermindConstants;
import br.com.mastermind.dao.IGuessDAO;
import br.com.mastermind.dto.GameDTO;
import br.com.mastermind.dto.GuessRequestDTO;
import br.com.mastermind.dto.GuessResponseDTO;
import br.com.mastermind.dto.PlayerDTO;
import br.com.mastermind.dto.PlayerGuessesDTO;
import br.com.mastermind.service.IGameService;
import br.com.mastermind.service.IGuessService;
import br.com.mastermind.service.IPlayerService;

/**
 * Implementation of the methods that access the guesses information.
 * 
 * @author Eduardo Jolo
 *
 */
@Service
public class GuessServiceImpl implements IGuessService {

	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IPlayerService playerService;
	
	@Autowired
	private IGuessDAO guessDAO;
	
	@Override
	public GuessResponseDTO guess(GuessRequestDTO guessRequestDTO) {
		
		GameDTO game = gameService.getGame(guessRequestDTO.getGameKey());
		PlayerDTO playerDTO = playerService.getPlayer(guessRequestDTO.getPlayerKey());
		
		GuessResponseDTO guessResponseDTO = this.checkGuessCode(game.getCode(), game.getCodeColors(), guessRequestDTO.getGuessedCode());
		
		this.saveGuess(guessRequestDTO.getGameKey(), guessRequestDTO.getPlayerKey(), playerDTO.getPlayerName(), guessRequestDTO.getGuessedCode());
		
		if(guessResponseDTO.isCorrectCode()) {
			gameService.updateWinner(guessRequestDTO.getGameKey(), playerDTO.getPlayerName());
		}
		
		return guessResponseDTO;
	}
	
	/**
	 * Check the given guess against the game code.
	 * 
	 * @param code Game code
	 * @param codeColors Different colors in the game code
	 * @param guessCode Guessed code
	 * @return Check result
	 */
	private GuessResponseDTO checkGuessCode(List<Character> code, Set<Character> codeColors, List<Character> guessCode) {
		GuessResponseDTO response = new GuessResponseDTO();
		
		List<Character> keyPegs = new ArrayList<>();
		List<Character> whiteKeyPegsColors = new ArrayList<>();
		
		Character guessedCodePeg;
		int countBlackKeyPegs = 0;
		for(int i = 0; i < guessCode.size(); i++) {
			guessedCodePeg = guessCode.get(i);
			
			if(guessedCodePeg.equals(code.get(i))) {
				keyPegs.add(MastermindConstants.BLACK_KEY_PEG);
				countBlackKeyPegs++;
				
			} else if(codeColors.contains(guessedCodePeg) && !whiteKeyPegsColors.contains(guessedCodePeg)) {
				keyPegs.add(MastermindConstants.WHITE_KEY_PEG);
				whiteKeyPegsColors.add(guessedCodePeg);
			}
		}
		
		response.setKeyPegs(keyPegs);
		response.setCorrectCode(countBlackKeyPegs == MastermindConstants.NUMBER_OF_POSITIONS);
		
		return response;
	}
	
	/**
	 * Save the guess.
	 * 
	 * @param gameKey Game key
	 * @param playerKey Player key
	 * @param playerName Player name
	 * @param guessCode Guessed code
	 */
	private synchronized void saveGuess(String gameKey, String playerKey, String playerName, List<Character> guessCode) {
		Map<String, PlayerGuessesDTO> mapGameGuesses = guessDAO.findGuesses(gameKey);
		
		PlayerGuessesDTO playerGuesses = null;
		if(mapGameGuesses == null) {
			mapGameGuesses = new HashMap<String, PlayerGuessesDTO>();
		} else {
			playerGuesses = mapGameGuesses.get(playerKey);
		}
		
		if(playerGuesses == null) {
			playerGuesses = new PlayerGuessesDTO(playerName);
		}
		
		playerGuesses.getGuesses().add(guessCode);
		
		mapGameGuesses.put(playerKey, playerGuesses);
		
		guessDAO.saveGuesses(gameKey, mapGameGuesses);
	}
	
	
}
