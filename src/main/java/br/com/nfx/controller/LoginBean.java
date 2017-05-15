/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfx.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.nfx.model.Usuario;
import br.com.nfx.repository.Usuarios;
import br.com.nfx.service.CadastroUsuarioService;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

/**
 *
 * @author Leonardo
 */
@Named(value = "auth")
@Data
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	// LoginController auth = new LoginController();
	private List<Usuario> listUsers;
	private String user;
	private String senha;
	private Boolean isadmin;
	private Boolean isativo;

	private Boolean loggedIn;

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private FacesMessages messages;

	public String validateUsernamePassword() throws IOException {
		RequestContext context = RequestContext.getCurrentInstance();
		Usuario usu = null;
		try {
			usu = cadastroUsuario.getUsuarioLogin(user, senha);
		} catch (Exception e) {
			System.out.println("getUsuarioService(): " + cadastroUsuario);
			e.printStackTrace();
		}
		
		if (usu != null) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("username", user);
			context.addCallbackParam("loggedIn", true);
			System.out.println("Direcionando para pagina inicial!!!");
			loggedIn = true;
			
			ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
			context1.redirect(context1.getRequestContextPath() + "/views/principal.jsf");
			
			//return "";
			//return "/views/layout.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário ou senha incorreto","Por favor, informe usuário e senha correto."));
				loggedIn = false;
			return "index";
		}
		return "/views/principal.xhtml";
	}
	
	public void isSessionValid() {

		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			final FacesContext context = FacesContext.getCurrentInstance();
			final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			final HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.invalidate();

			isadmin = false;
			isativo = false;
			System.out.println("isSessionValid");

		} catch (Exception e) {
			System.out.println(" Error invalidating session :: " + e.getMessage());
		}
	}

	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		final FacesContext context = FacesContext.getCurrentInstance();
		final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		final HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();

		isadmin = false;
		isativo = false;
		System.out.println("LOGOUT");

		ExternalContext con = FacesContext.getCurrentInstance().getExternalContext();
//		try {
//			con.redirect(con.getRequestContextPath() + "/index.jsf");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "index";
	}

}
