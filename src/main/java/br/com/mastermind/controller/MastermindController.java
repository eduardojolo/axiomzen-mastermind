package br.com.mastermind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastermind.dto.CreateGameResponseDTO;

@RestController
public class MastermindController {

	@RequestMapping(value="/mastermind/sayhello", method= RequestMethod.GET)
	public String sayHello() {
		return "Heeello!";
	}
	
	@RequestMapping(value="/newgame", method= RequestMethod.POST)
	public CreateGameResponseDTO newGame(@RequestParam String userName) {
		
		return null;
	}
}
