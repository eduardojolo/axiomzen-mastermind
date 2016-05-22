package br.com.mastermind.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.mastermind.constants.MastermindConstants;
import br.com.mastermind.dao.IGameDAO;
import br.com.mastermind.dao.IGuessDAO;
import br.com.mastermind.dto.EnterGameResponseDTO;
import br.com.mastermind.dto.GameDTO;
import br.com.mastermind.dto.GameGuessesResponseDTO;
import br.com.mastermind.dto.JoinGameRequestDTO;
import br.com.mastermind.dto.PlayerDTO;
import br.com.mastermind.dto.PlayerGuessesDTO;
import br.com.mastermind.exceptions.NoGameWasFoundException;
import br.com.mastermind.service.IGameService;
import br.com.mastermind.service.IPlayerService;
import br.com.mastermind.util.CryptoUtil;

/**
 * Implementation of the methods that access the game information.
 * 
 * @author Eduardo Jolo
 *
 */
@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	private IPlayerService playerService;

	@Autowired
	private IGameDAO gameDAO;

	@Autowired
	private IGuessDAO guessDAO;

	@Override
	public EnterGameResponseDTO newGame(String playerName) {

		Long timeInMillis = Calendar.getInstance().getTimeInMillis();
		String gameKey = CryptoUtil.encryptString(timeInMillis + playerName);
		String playerKey = CryptoUtil.encryptString(playerName + gameKey);

		this.createGame(gameKey, timeInMillis);

		playerService.savePlayer(new PlayerDTO(playerKey, playerName));

		return new EnterGameResponseDTO(playerKey, gameKey);
	}

	@Override
	public EnterGameResponseDTO joinGame(JoinGameRequestDTO joinGameRequestDTO) {
		GameDTO game = this.getGame(joinGameRequestDTO.getGameKey());

		String playerKey = CryptoUtil.encryptString(joinGameRequestDTO.getPlayerName() + game.getGameKey());

		playerService.savePlayer(new PlayerDTO(playerKey, joinGameRequestDTO.getPlayerName()));

		return new EnterGameResponseDTO(playerKey, game.getGameKey());
	}

	@Override
	public GameGuessesResponseDTO getPlayerGuessesForGame(String gameKey) {
		GameDTO game = this.getGame(gameKey);
		Map<String, PlayerGuessesDTO> mapGameGuesses = guessDAO.findGuesses(gameKey);

		return new GameGuessesResponseDTO(game.getWinner(), new ArrayList<PlayerGuessesDTO>(mapGameGuesses.values()));
	}

	@Override
	public synchronized void updateWinner(String gameKey, String playerName) {
		GameDTO game = this.getGame(gameKey);

		if (StringUtils.isEmpty(game.getWinner())) {
			game.setWinner(playerName);

			gameDAO.saveGame(game);
		}
	}

	@Override
	public GameDTO getGame(String gameKey) {
		GameDTO game = gameDAO.findGame(gameKey);

		if (game == null) {
			throw new NoGameWasFoundException(gameKey);
		}

		return game;
	}

	/**
	 * Create the game.
	 * 
	 * @param gameKey
	 *            Game key
	 * @param timeInMillis
	 *            start time
	 */
	private void createGame(String gameKey, Long timeInMillis) {
		List<Character> code = this.generateCode();

		GameDTO newGame = new GameDTO(gameKey, code, timeInMillis, new HashSet<>(code));

		gameDAO.saveGame(newGame);
	}

	/**
	 * Generate a new game code.
	 * 
	 * @return List of colors in the code
	 */
	private List<Character> generateCode() {
		List<Character> code = new ArrayList<Character>();
		Random randomGenerator = new Random();

		for (int i = 0; i < MastermindConstants.NUMBER_OF_POSITIONS; i++) {
			code.add(MastermindConstants.COLORS.get(randomGenerator.nextInt(MastermindConstants.NUMBER_OF_COLORS)));
		}

		return code;
	}

}
