package com.wallacemachado.workshopmongo.Repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wallacemachado.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//busca usando script automaticos do MongoDB para isso precisamos inserir o @Query...
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> buscarPeloTitulo(String text);
}
