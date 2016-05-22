package br.com.mastermind.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mastermind.dao.IPlayerDAO;
import br.com.mastermind.dto.PlayerDTO;
import br.com.mastermind.exceptions.NoPlayerWasFoundException;
import br.com.mastermind.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	private IPlayerDAO playerDAO;
	
	@Override
	public PlayerDTO getPlayer(String playerKey) {
		PlayerDTO playerDTO = playerDAO.findPlayer(playerKey);
		
		if(playerDTO == null) {
			throw new NoPlayerWasFoundException(playerKey);
		}
		
		return playerDTO;
	}

}
