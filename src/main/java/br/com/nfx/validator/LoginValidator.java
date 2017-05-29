package br.com.nfx.validator;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

import org.hibernate.mapping.Component;
import org.primefaces.component.messages.Messages;
import org.primefaces.validate.bean.ClientValidationConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.nfx.model.Usuario;
import br.com.nfx.repository.Usuarios;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

@Data
public abstract class LoginValidator implements ClientValidationConstraint {

	private static final long serialVersionUID = 6086372792387091314L;

	@Autowired
	private Usuarios usuarios;

	@Autowired
	private FacesMessages messages;

	@SuppressWarnings("unchecked")
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
//		EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
//		String newEmail = (String) value;
//		String login = String.valueOf(component.getAttributes().get("login"));
//		if (login != null && !login.equalsIgnoreCase(newEmail)) {
//			Usuario users = usuarios.findByLogin(login);
//			if (!users.toString().isEmpty()) {
//				Map<String, String> messages = Messages.instance();
//				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
//						messages.get("admin.emailexists"), messages.get("admin.emailexists")));
//			}
//		}
	}
}