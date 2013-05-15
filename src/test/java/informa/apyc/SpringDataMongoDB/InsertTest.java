package informa.apyc.SpringDataMongoDB;

import informa.apyc.SpringDataMongoDB.entities.Persona;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class InsertTest {

	@Autowired
	MongoOperations mongoOperations;

	@Test
	public void test() {

		insertPersona();
		
	}

	private void insertPersona(){
		
		Persona persona = new Persona();
		persona.setPaisID(UUID.randomUUID());
		persona.setFecNacimiento(new Date());
		persona.setNombre("Juan");
		persona.setApellidos("PŽrez");
		
		mongoOperations.insert(persona);
		
	}
	
}
