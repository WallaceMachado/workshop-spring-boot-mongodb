package com.wallacemachado.workshopmongo.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wallacemachado.workshopmongo.Repositories.PostRepository;
import com.wallacemachado.workshopmongo.Repositories.UsuarioRepository;
import com.wallacemachado.workshopmongo.domain.Post;
import com.wallacemachado.workshopmongo.domain.Usuario;

// para teste

@Configuration // informa que é uma configuração
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository userReposiroty;


	@Autowired
	private PostRepository postReposiroty;
	@Override
	public void run(String... arg0) throws Exception {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

	userReposiroty.deleteAll();
	postReposiroty.deleteAll();

	Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
	Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
	Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

	Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
	Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

	userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
	postReposiroty.saveAll(Arrays.asList(post1, post2));
	}
}