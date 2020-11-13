package com.wallacemachado.workshopmongo.resources;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wallacemachado.workshopmongo.domain.Usuario;



@RestController // informa que é um controller e responde a solicitação http
@RequestMapping(value="/users") // caminho
public class UsuarioResource {

	@RequestMapping(method=RequestMethod.GET) // responde a solicitação do tipo GET (poderia ser @GETMapping 
 	public ResponseEntity<List<Usuario>> findAll() {
		Usuario maria = new Usuario("1", "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario("2", "Alex Green", "alex@gmail.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
}
