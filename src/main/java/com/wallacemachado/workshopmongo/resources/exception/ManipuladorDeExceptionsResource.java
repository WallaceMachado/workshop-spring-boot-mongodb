package com.wallacemachado.workshopmongo.resources.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wallacemachado.workshopmongo.services.exception.ObjetoNaoEncontradoException;



@ControllerAdvice // torna a classe responsavel por tratar possivel erros nas requisiçoes http
public class ManipuladorDeExceptionsResource {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)// quando aconter essa excessão deve fazer o tratamento abaixo
	public ResponseEntity<ErrorPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorPadrao err = new ErrorPadrao(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
