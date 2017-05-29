package br.com.nfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nfx.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public Usuario findByLoginAndSenha(String login, String senha);
	public Usuario findByLogin(String login);

}
