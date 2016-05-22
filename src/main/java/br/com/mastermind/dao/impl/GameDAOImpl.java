package br.com.mastermind.dao.impl;

import org.springframework.stereotype.Service;

import com.hazelcast.core.IMap;

import br.com.mastermind.dao.IGameDAO;
import br.com.mastermind.dto.GameDTO;
import br.com.mastermind.hazelcast.HazelcastConfiguration;
import br.com.mastermind.hazelcast.HazelcastMastermindUtil;

@Service
public class GameDAOImpl implements IGameDAO {

	@Override
	public GameDTO findGame(String gameKey) {
		IMap<String, Object> gameCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.GAME_CACHE_MAP_NAME);
		
		GameDTO game = (GameDTO) gameCache.get(gameKey);
		
		if(game == null) {
			// go to database
		}
		
		return game;
	}
	
	@Override
	public void saveGame(GameDTO gameDTO) {
		IMap<String, Object> gameCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.GAME_CACHE_MAP_NAME);
		
		gameCache.put(gameDTO.getGameKey(), gameDTO);
	}

}
