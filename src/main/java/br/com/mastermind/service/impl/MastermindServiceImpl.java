package br.com.mastermind.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.mastermind.constants.MastermindConstants;
import br.com.mastermind.dto.CreateGameResponseDTO;
import br.com.mastermind.dto.GameDTO;
import br.com.mastermind.dto.GuessRequestDTO;
import br.com.mastermind.service.IMastermindService;
import br.com.mastermind.utils.CryptoUtils;

@Service
public class MastermindServiceImpl implements IMastermindService {

	@Override
	public CreateGameResponseDTO newGame(String userName) {
		CreateGameResponseDTO response = new CreateGameResponseDTO();

		Long timeInMillis = Calendar.getInstance().getTimeInMillis();
		String gameKey = CryptoUtils.encryptString(timeInMillis + userName);
		response.setGameKey(gameKey);
		response.setPlayerKey(CryptoUtils.encryptString(userName));

		this.createGame(gameKey, timeInMillis);

		return response;
	}

	private List<Character> generateCode() {
		List<Character> code = new ArrayList<Character>();
		Random randomGenerator = new Random();

		for (int i = 0; i < MastermindConstants.NUMBER_OF_POSITIONS; i++) {
			code.add(MastermindConstants.COLORS.get(randomGenerator.nextInt(MastermindConstants.NUMBER_OF_COLORS)));
		}

		return code;
	}

	private void createGame(String gameKey, Long timeInMillis) {
		List<Character> code = this.generateCode();

		GameDTO newGame = new GameDTO(gameKey, code, timeInMillis, new HashSet<>(code));

		// store game in cache
	}

	public List<Character> guess(GuessRequestDTO guessRequestDTO) {
		
		GameDTO game = new GameDTO();

		return this.checkGuessCode(game.getCode(), game.getCodeColors(), guessRequestDTO.getGuessedCode());
	}
	
	private List<Character> checkGuessCode(List<Character> code, Set<Character> codeColors, List<Character> guessCode) {
		List<Character> keyPegs = new ArrayList<>();
		List<Character> whiteKeyPegsColors = new ArrayList<>();
		
		Character guessedCodePeg;
		for(int i = 0; i < guessCode.size(); i++) {
			guessedCodePeg = guessCode.get(i);
			
			if(guessedCodePeg.equals(code.get(i))) {
				keyPegs.add(MastermindConstants.BLACK_KEY_PEG);
				
			} else if(codeColors.contains(guessedCodePeg) && !whiteKeyPegsColors.contains(guessedCodePeg)) {
				keyPegs.add(MastermindConstants.WHITE_KEY_PEG);
				whiteKeyPegsColors.add(guessedCodePeg);
			}
		}
		
		return keyPegs;
	}
}
