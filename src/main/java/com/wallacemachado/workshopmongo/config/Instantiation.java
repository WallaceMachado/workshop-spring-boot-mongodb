package com.wallacemachado.workshopmongo.config;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wallacemachado.workshopmongo.Repositories.UsuarioRepository;
import com.wallacemachado.workshopmongo.domain.Usuario;

// para teste

@Configuration // informa que é uma configuração
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository userReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		userReposiroty.deleteAll();

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
	}

}