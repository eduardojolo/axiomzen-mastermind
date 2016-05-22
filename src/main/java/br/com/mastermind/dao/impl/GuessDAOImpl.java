package br.com.mastermind.dao.impl;

import java.util.Map;

import com.hazelcast.core.IMap;

import br.com.mastermind.dao.IGuessDAO;
import br.com.mastermind.dto.PlayerGuessesDTO;
import br.com.mastermind.hazelcast.HazelcastConfiguration;
import br.com.mastermind.hazelcast.HazelcastMastermindUtil;

public class GuessDAOImpl implements IGuessDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, PlayerGuessesDTO> findGuesses(String gameKey) {
		IMap<String, Object> guessCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.GUESSES_CACHE_MAP_NAME);
		
		Map<String, PlayerGuessesDTO> guesses = (Map<String, PlayerGuessesDTO>) guessCache.get(gameKey);
		
		if(guesses == null) {
			// go to database
		}
		
		return guesses;
	}

	@Override
	public void saveGuesses(String playerKey, Map<String, PlayerGuessesDTO> guesses) {
		IMap<String, Object> guessCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.GUESSES_CACHE_MAP_NAME);
		
		guessCache.put(playerKey, guesses);
	}

}
