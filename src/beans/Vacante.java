package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class Vacante extends Object{
	
	Logger log = LogManager.getRootLogger();

	@Inject
	private Persona per;
	
	private boolean comentarioEnviado;

	public Persona getPer() {
		return per;
	}

	public void setPer(Persona per) {
		this.per = per;
	}
	
	public String enviar() {
		if(this.per.getNombre().equals("Edgar")) {
			if (this.per.getApellido().equals("Ojeda")) {
				String msg = "El usuario, Edgar Ojeda ya pertenece a nuestro personal";
				FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);	// Crear mensaje
				FacesContext fc = FacesContext.getCurrentInstance();	// Crear objeto faces context
				fc.addMessage(null, fm);	// Generar mensaje
				return "index";
			}
			log.info("Entrando al caso de exito");
			return "exito";
		} else {
			log.info("Entrando al caso de fallo");
			return "fallo";
		}
	}
	
	public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {
		FacesContext fc = FacesContext.getCurrentInstance();
		UIViewRoot vista = fc.getViewRoot(); // Obtener cualquier componente de la vista.
		String newCodigoPostal = (String) valueChangeEvent.getNewValue();  // Obtener el nuevo valor suministrado en el inputText.

		if ("100".equals(newCodigoPostal)) {	// si el codigo obtenido es igual a 100.
			UIInput coloniaText = (UIInput) vista.findComponent("form:colonia"); // Obtener componente de vista
			String colonia = "Santiago Centro";
			// Establecer nuevo valor.
			coloniaText.setValue(colonia);
			coloniaText.setSubmittedValue(colonia);

			UIInput ciudadText = (UIInput) vista.findComponent("form:ciudad"); // Obtener componente de vista
			String ciudad = "Metropolitana de Santiago";
			ciudadText.setValue(ciudad);
			ciudadText.setSubmittedValue(ciudad);
			
			fc.renderResponse(); // ENviar respuesta
		}
	}
	
	public void ocultarComentario(ActionEvent actionEvent) { // Este metodo solo invertira el valor que tenga el parametro comentarioEnviado.
		this.comentarioEnviado = !this.comentarioEnviado;
	}

	public boolean getComentarioEnviado() {
		return comentarioEnviado;
	}

	public void setComentarioEnviado(boolean comentarioEnviado) {
		this.comentarioEnviado = comentarioEnviado;
	}

	
}
