package com.wallacemachado.workshopmongo.resources;



import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wallacemachado.workshopmongo.DTO.UsuarioDTO;
import com.wallacemachado.workshopmongo.domain.Usuario;
import com.wallacemachado.workshopmongo.services.UsuarioService;



@RestController // informa que é um controller e responde a solicitação http
@RequestMapping(value="/users") // caminho
public class UsuarioResource {

	@Autowired
	private UsuarioService service; // injeção de de pendência
	
	@RequestMapping(method=RequestMethod.GET) // responde a solicitação do tipo GET (poderia ser @GETMapping 
 	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll(); // lista com os usuarios do Banco
		
		// converte a lista com os usuarios do Banco para um alista de usuario DTO (customizados os dados que serão exibidos)
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
	 	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
			Usuario obj = service.findById(id);
			return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
		
		@RequestMapping(method=RequestMethod.POST)
	 	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto) {
			Usuario obj = service.fromDTO(objDto);
			obj = service.insert(obj);
			
			//pega a URL do objeto criado
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			// retorna um objeto vazio porém retorna a url do objeto criado 
			return ResponseEntity.created(uri).build();
		}
}
