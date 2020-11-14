package com.wallacemachado.workshopmongo.Repositories;
import java.util.Date;
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
	
	// busca considerando titulo ou o corpo do post ou comentario em um intervalo de datas
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
