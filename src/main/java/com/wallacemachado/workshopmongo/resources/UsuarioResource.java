package com.wallacemachado.workshopmongo.resources;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wallacemachado.workshopmongo.domain.Usuario;
import com.wallacemachado.workshopmongo.services.UsuarioService;



@RestController // informa que é um controller e responde a solicitação http
@RequestMapping(value="/users") // caminho
public class UsuarioResource {

	@Autowired
	private UsuarioService service; // injeção de de pendência
	
	@RequestMapping(method=RequestMethod.GET) // responde a solicitação do tipo GET (poderia ser @GETMapping 
 	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
