package informa.apyc.SpringDataMongoDB;

import informa.apyc.SpringDataMongoDB.entities.Post;
import informa.apyc.SpringDataMongoDB.entities.Usuario;
import informa.apyc.SpringDataMongoDB.repositories.PostRepository;
import informa.apyc.SpringDataMongoDB.repositories.UsuarioRepository;
import informa.apyc.SpringDataMongoDB.service.PostService;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	MongoOperations mongoOperations;
	@Autowired
	PostService postService;

	@Test
	public void test() {

		dropCollections();
		insertPostConUsuario();
		insertPostConUsuario2();
		findAll();
		findByUsername();
//		deleteUsuario();
		
	}

	private void dropCollections(){
		mongoOperations.dropCollection(Usuario.class);
		mongoOperations.dropCollection(Post.class);
	}
	
	private void insertPostConUsuario(){
		
		Usuario usuario = new Usuario();
		usuario.setUsername("pedro");
		usuario.setPassword("pass");
		usuarioRepository.save(usuario);
		
		Post post = new Post();
		post.setUsuario(usuario);
		post.setSubject("Asunto 2");
		post.setContent("Contenido 2");
		postService.save(post);
		
	}
	
	private void insertPostConUsuario2(){
		
		Post post = new Post();
		post.setSubject("Asunto");
		post.setContent("Contenido");
		postRepository.save(post);
		
		Usuario usuario = new Usuario();
		usuario.setUsername("angel");
		usuario.setPassword("angel");
		usuarioRepository.save(usuario);
		
		post.setUsuario(usuario);
		postRepository.save(post);
		
	}
	
	private void findAll(){
		
		for (Post post : postService.findAll()){
			System.out.println(new Gson().toJson(post));
		}
		
	}
	
	private void deleteUsuario(){
		
		Usuario usuario = usuarioRepository.findByUsername("angel");
		usuarioRepository.delete(usuario);
		
		for (Post post : postRepository.findAll()){
			System.out.println(new Gson().toJson(post));
		}
		
	}
	
	private void findByUsername(){
		
		Collection<Post> posts = postService.findPostByUsername("angel");
		
		System.out.println("Encontrados "+posts.size()+ " temas para el usuario");
		
		for (Post post : posts){
			System.out.println(new Gson().toJson(post));
		}
		
	}
	
}
