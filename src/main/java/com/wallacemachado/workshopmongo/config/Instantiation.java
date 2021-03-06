package com.wallacemachado.workshopmongo.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wallacemachado.workshopmongo.DTO.AuthorDTO;
import com.wallacemachado.workshopmongo.DTO.ComentarioDTO;
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
	
	userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

	Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
	Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

	ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
	ComentarioDTO c2 = new ComentarioDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
	ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

	post1.getComments().addAll(Arrays.asList(c1, c2));
	post2.getComments().addAll(Arrays.asList(c3));
	
	postReposiroty.saveAll(Arrays.asList(post1, post2));
	
	maria.getPosts().addAll(Arrays.asList(post1, post2));
	userReposiroty.save(maria);
	}
}