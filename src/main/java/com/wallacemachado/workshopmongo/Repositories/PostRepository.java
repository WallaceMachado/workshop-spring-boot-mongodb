package com.wallacemachado.workshopmongo.Repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallacemachado.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//método findByTitleContainingIgnoreCase é padrão já determinado pelo Springboot e tem que ter esse nome
	// o ignoreCase é para ignorar a diferença de letras maiusculas e minusculas
	List<Post> findByTitleContainingIgnoreCase(String text);
}
