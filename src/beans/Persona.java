package beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class Persona extends Object{
	
	Logger log = LogManager.getRootLogger();
	
	private String nombre;
	private String apellido;
	private String rut;
	private Date fecha;
	private String codigoPostal;
	private String colonia;
	private String ciudad;
	private String tecnologia;
	private String comentario;
	
	public Persona() {
		log.info("Creando objeto persona");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		log.info("Modificando nombre de persona con el valor :" + this.nombre);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
		log.info("Modificando apellido de persona con el valor :" + this.apellido);
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
		log.info("Modificando rut de persona con el valor :" + this.rut);
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", fecha=" + fecha
				+ ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + ", ciudad=" + ciudad + ", tecnologia="
				+ tecnologia + ", comentario=" + comentario + "]";
	}
}
