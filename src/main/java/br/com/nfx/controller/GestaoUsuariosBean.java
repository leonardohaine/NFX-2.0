package br.com.nfx.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.nfx.model.Role;
import br.com.nfx.model.Usuario;
import br.com.nfx.repository.Roles;
import br.com.nfx.repository.Usuarios;
import br.com.nfx.service.CadastroUsuarioService;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

@Named
@ViewScoped
@Data
public class GestaoUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Roles roles;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private FacesMessages messages;
	
	private List<Usuario> todosUsuarios;
	private List<Usuario> usuariosFiltrados;
	
	private Usuario usuarioEdicao = new Usuario();
	private Usuario usuarioSelecionado;
	
	private List<Role> role;
	private DualListModel<Role> roleModel;
	
	
	public DualListModel<Role> getRoleModel(){
		// if(this.roleModel==null){ 
			 if(usuarioEdicao.getRole() != null){
				 this.roleModel = new DualListModel<Role>(new ArrayList<>(role), new ArrayList<Role>(usuarioEdicao.getRole()));
			 }else{
				 this.roleModel = new DualListModel<Role>(new ArrayList<>(role), new ArrayList<Role>());
			 }
		// }
		 return this.roleModel;
	}
	
	public void prepararNovoCadastro() {
		usuarioEdicao = new Usuario();
	}
	
	public void salvar() {
		usuarioEdicao.setRole(roleModel.getTarget());
		try{
			
			if(usuarios.findByLogin(usuarioEdicao.getLogin()) != null){
				FacesMessage message = new FacesMessage("Usuário já existe!");
				throw new ValidatorException(message);
			}
			cadastroUsuario.salvar(usuarioEdicao);
			consultar();
			messages.info("Usuário salvo com sucesso!");
		}catch (DataIntegrityViolationException e) {
			
		}
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:usuarios-table"));
	}
	
	public void excluir() {
		cadastroUsuario.excluir(usuarioSelecionado);
		usuarioSelecionado = null;
		
		consultar();
		
		messages.info("Usuário excluído com sucesso!");
	}
	
	@PostConstruct
	public void consultarRole(){
		 role = roles.findAll();
	}
	
	public void consultar() {
		todosUsuarios = usuarios.findAll();
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}
	
	public String[] data = {"1","2","3"};
	   
	
	public void onRowSelect(SelectEvent event) {
         Usuario usu = (Usuario) event.getObject();
         //role = usu.getRole();
         usuarioEdicao = usu;
         for(Role r : usu.getRole()){
        	 System.out.println("ID: " + r.getRoleId() + " - REGRAS: " + r.getRole());
         }
         //this.roleModel = new DualListModel<Role>(new ArrayList<>(role), new ArrayList<Role>(usuarioEdicao.getRole()));
    }

	public Usuario getUsuarioEdicao() {
		
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
}