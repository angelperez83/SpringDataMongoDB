package informa.apyc.SpringDataMongoDB.repositories;

import informa.apyc.SpringDataMongoDB.entities.Post;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, ObjectId>{

	

}
