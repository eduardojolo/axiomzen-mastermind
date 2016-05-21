package br.com.mastermind.service;

import br.com.mastermind.dto.CreateGameResponseDTO;

public interface IMastermindService {

	CreateGameResponseDTO newGame(String userName);
}
