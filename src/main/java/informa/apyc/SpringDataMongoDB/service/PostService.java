package informa.apyc.SpringDataMongoDB.service;

import informa.apyc.SpringDataMongoDB.entities.Post;
import informa.apyc.SpringDataMongoDB.entities.Usuario;
import informa.apyc.SpringDataMongoDB.repositories.PostRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	@Autowired
	MongoOperations mongoOperations;
	
	//Usando el repository
	public Collection<Post> findAll(){
		
		return (Collection<Post>) postRepository.findAll();
		
	}
	
	public Post save(Post post){
		post = postRepository.save(post);
		System.out.println("Post saved " + post.getId());
		return post;
	}
	
	//Usando el mongoOperationss
	public Collection<Post> findPostByUsername(String username){

		//No se puede usar dot notation ya que son documentos diferentes, primero tenemos que buscar los usuarios y luego los posts
		Collection<Usuario> usuario = mongoOperations.find(Query.query(Criteria.where("username").is(username)), Usuario.class);
		return mongoOperations.find(Query.query(Criteria.where("usuario").in(usuario)), Post.class);
		
	}

}
