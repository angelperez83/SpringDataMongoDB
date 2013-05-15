package informa.apyc.SpringDataMongoDB.repositories;

import informa.apyc.SpringDataMongoDB.entities.Persona;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, ObjectId>{

	
	public Persona findByNombre(String nombre);
	public Page<Persona> findByNombreContaining(String nombre, Pageable pageable);
	

}
