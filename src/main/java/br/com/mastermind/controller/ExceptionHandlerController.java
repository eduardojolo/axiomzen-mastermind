package br.com.mastermind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mastermind.dto.ErrorResponseDTO;
import br.com.mastermind.exceptions.MastermindGenericException;
import br.com.mastermind.exceptions.NoGameWasFoundException;

/**
 * Exception handler controller.
 * 
 * @author Eduardo Jolo
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {

	/**
	 * Handle the NoGameWasFoundException returning a better message to the requester.
	 * 
	 * @param noGameWasFoundException No game was found exception.
	 * @return ErrorResponseDTO
	 */
	@ExceptionHandler(NoGameWasFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponseDTO requestHandlingNoHandlerFound(NoGameWasFoundException noGameWasFoundException) {
		return new ErrorResponseDTO(noGameWasFoundException.getMessage());
	}
	
	/**
	 * Handle the MastermindGenericException returning a better message to the requester.
	 * 
	 * @param mastermindGenericException Mastermind internal exception
	 * @return ErrorResponseDTO
	 */
	@ExceptionHandler(MastermindGenericException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponseDTO requestHandlingNoHandlerFound(MastermindGenericException mastermindGenericException) {
		return new ErrorResponseDTO(mastermindGenericException.getMessage());
	}
}
