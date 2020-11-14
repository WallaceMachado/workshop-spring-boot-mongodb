package com.wallacemachado.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallacemachado.workshopmongo.Repositories.PostRepository;
import com.wallacemachado.workshopmongo.domain.Post;
import com.wallacemachado.workshopmongo.services.exception.ObjetoNaoEncontradoException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitulo(String text) {
		
		return repo.buscarPeloTitulo(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // menor que as 24 horas do dia seguinte
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
