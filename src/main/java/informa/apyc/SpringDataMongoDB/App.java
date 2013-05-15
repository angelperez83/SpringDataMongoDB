package informa.apyc.SpringDataMongoDB;

import java.util.Date;
import java.util.UUID;

import informa.apyc.SpringDataMongoDB.entities.Persona;
import informa.apyc.SpringDataMongoDB.repositories.PersonaRepository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");

		MongoOperations mongoOperations = context.getBean("mongoTemplate", MongoOperations.class);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Inserting
		/*
		
		Persona persona = new Persona();
		persona.setPaisID(UUID.randomUUID());
		persona.setFecNacimiento(new Date());
		persona.setNombre("Juan");
		persona.setApellidos("PŽrez");
		mongoOperations.insert(persona);
		 */
		
		//FindByOne
		/*
		Persona persona = mongoOperations.findOne(Query.query(Criteria.where("nombre").is("Juan")), Persona.class);
		System.out.println(gson.toJson(persona));
		*/
		
//		for (int i=0; i<10;i++){
//			Persona persona = new Persona();
//			persona.setPaisID(UUID.randomUUID());
//			persona.setFecNacimiento(new Date());
//			persona.setNombre("Juan " + i);
//			persona.setApellidos("PŽrez");
//			mongoOperations.insert(persona);
//		}
		
		
		PersonaRepository personaRepository = context.getBean("personaRepository", PersonaRepository.class);
		
		//Repos
		/*
		Persona persona = personaRepository.findByNombre("Juan");
		System.out.println(gson.toJson(persona));
		*/
		
		//Upsert comentario

		/*
		//PUSH
		Comentario comentario = new Comentario();
		comentario.setNombre("Angel");
		comentario.setFecha(new Date());
		comentario.setTexto("Comentario de ejemplo");
		
		System.out.println(gson.toJson(comentario));
		
		mongoOperations.upsert(Query.query(Criteria.where("nombre").is("Juan")), 
				new Update().push("comentarios", comentario),
				Persona.class);
		 */
		
		/*
		 //POP
		mongoOperations.upsert(Query.query(Criteria.where("nombre").is("Juan")), 
				new Update().pop("comentarios", Position.FIRST),
				Persona.class);
		*/
		
		/*
		 // Comentados por mi (dot notation)
		Persona persona = mongoOperations.findOne(Query.query(Criteria.where("comentarios.nombre").is("Angel")), Persona.class);
		System.out.println(gson.toJson(persona));
		*/
		
		/*
		 //Inc. contador operacion atomica
	
		Comentario comentario = new Comentario();
		comentario.setNombre("Jose");
		comentario.setFecha(new Date());
		comentario.setTexto("Me debe dinero");
		
		mongoOperations.upsert(Query.query(Criteria.where("nombre").is("Juan")), 
				new Update().push("comentarios", comentario)
							.inc("numComentarios", 1),
				Persona.class);
		 */
	
		/*
		 // ReadPreference - Leer de un secondario (puede que los datos no esten actualizados (depende del writeConern que utilicemos)
		 
		
		mongoOperations.getCollection("persona").setReadPreference(ReadPreference.secondaryPreferred());
		Persona persona = mongoOperations.findOne(Query.query(Criteria.where("comentarios.nombre").is("Jose")), Persona.class);
		System.out.println(gson.toJson(persona));
		
		*/
		
		
		System.out.println("FIN");
		
	}

}
