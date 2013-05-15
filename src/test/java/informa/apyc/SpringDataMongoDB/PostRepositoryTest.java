package informa.apyc.SpringDataMongoDB;

import informa.apyc.SpringDataMongoDB.entities.Persona;
import informa.apyc.SpringDataMongoDB.repositories.PersonaRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PostRepositoryTest {

	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	public void test() {

		findByNombreContaining();
		
	}

	private void findByNombreContaining(){

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Pageable pageable = new PageRequest(0, 5, Direction.DESC, "nombre");
		Page<Persona> page = personaRepository.findByNombreContaining("an", pageable );
		
		System.out.println("Size: " + page.getSize());
		System.out.println("Number of elements: " + page.getNumberOfElements());
		
		System.out.println("Total elementos: " + page.getTotalElements());
		System.out.println("Total p‡ginas: " + page.getTotalPages());
		
		for (Persona persona : page)
			System.out.println(gson.toJson(persona));
		
		
	}
	
}
