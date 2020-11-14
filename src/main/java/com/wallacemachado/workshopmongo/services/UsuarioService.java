package com.wallacemachado.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallacemachado.workshopmongo.DTO.UsuarioDTO;
import com.wallacemachado.workshopmongo.Repositories.UsuarioRepository;
import com.wallacemachado.workshopmongo.domain.Usuario;
import com.wallacemachado.workshopmongo.services.exception.ObjetoNaoEncontradoException;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
		}
	
	public Usuario insert(Usuario obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); // já trata as exceções especificadas no findById
		repo.deleteById(id);
	}

	//convert o UsuarioDTO  em usurio do banco 
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
