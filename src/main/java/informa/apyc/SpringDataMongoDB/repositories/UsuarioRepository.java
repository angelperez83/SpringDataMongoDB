package informa.apyc.SpringDataMongoDB.repositories;

import informa.apyc.SpringDataMongoDB.entities.Usuario;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, ObjectId>{

	public Usuario findByUsername(String username);

}
