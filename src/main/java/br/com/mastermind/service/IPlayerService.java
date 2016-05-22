package br.com.mastermind.service;

import br.com.mastermind.dto.PlayerDTO;

public interface IPlayerService {

	PlayerDTO getPlayer(String playerKey);
}
