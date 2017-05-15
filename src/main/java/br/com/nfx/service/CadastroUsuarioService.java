package br.com.nfx.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nfx.model.Usuario;
import br.com.nfx.repository.Usuarios;

@Service
public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public void salvar(Usuario usuario) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(hashedPassword);
		usuarios.save(usuario);
	}
	
	@Transactional
	public void excluir(Usuario usuario) {
		usuarios.delete(usuario);
	}
	
	public Usuario getUsuarioLogin(String login, String senha){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(senha);
		return getUsuarioLogin(login, hashedPassword);
		
	}

}