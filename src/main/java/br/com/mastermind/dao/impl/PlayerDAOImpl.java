package br.com.mastermind.dao.impl;

import org.springframework.stereotype.Service;

import com.hazelcast.core.IMap;

import br.com.mastermind.dao.IPlayerDAO;
import br.com.mastermind.dto.PlayerDTO;
import br.com.mastermind.hazelcast.HazelcastConfiguration;
import br.com.mastermind.hazelcast.HazelcastMastermindUtil;

/**
 * Implementation of the methods that interact with the player entity.
 * 
 * @author Eduardo Jolo
 *
 */
@Service
public class PlayerDAOImpl implements IPlayerDAO{

	@Override
	public PlayerDTO findPlayer(String playerKey) {
		IMap<String, Object> playerCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.PLAYERS_CACHE_MAP_NAME);
		
		PlayerDTO player = (PlayerDTO) playerCache.get(playerKey);
		
		return player;
	}

	@Override
	public void savePlayer(PlayerDTO playerDTO) {
		IMap<String, Object> playerCache = HazelcastMastermindUtil.getIMap(HazelcastConfiguration.PLAYERS_CACHE_MAP_NAME);
		
		playerCache.put(playerDTO.getPlayerKey(), playerDTO);
	}

}
