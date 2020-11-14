package com.wallacemachado.workshopmongo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallacemachado.workshopmongo.domain.Usuario;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> { 

}
