package com.evolent.contacts.CustomExceptions;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	@ExceptionHandler(ConversionFailedException.class)
	public ResponseEntity<String> handleConflict(RuntimeException re){
		return new ResponseEntity<>(re.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
