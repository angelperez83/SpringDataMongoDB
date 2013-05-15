package informa.apyc.SpringDataMongoDB.entities;

import informa.apyc.SpringDataMongoDB.entities.utils.Comentario;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Persona {

	@Id
	private ObjectId id;
	private UUID paisID;
	private String nombre;
	private String apellidos;
	private Date fecNacimiento;
	private byte[] textoLibre;
	private List<Comentario> comentarios;
	private int numComentarios;
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public byte[] getTextoLibre() {
		return textoLibre;
	}
	public void setTextoLibre(byte[] textoLibre) {
		this.textoLibre = textoLibre;
	}
	public UUID getPaisID() {
		return paisID;
	}
	public void setPaisID(UUID paisID) {
		this.paisID = paisID;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public int getNumComentarios() {
		return numComentarios;
	}
	public void setNumComentarios(int numComentarios) {
		this.numComentarios = numComentarios;
	}

	
	
	

}
