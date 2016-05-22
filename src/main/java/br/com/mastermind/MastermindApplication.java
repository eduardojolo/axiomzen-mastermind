package br.com.mastermind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Mastermind application to be started as a standalone microservice.
 * 
 * @author Eduardo Jolo
 *
 */
@SpringBootApplication
public class MastermindApplication {

	/**
	 * Main method that starts the microservice.
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MastermindApplication.class, args);
	}
}
