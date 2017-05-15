package br.com.nfx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nfx.model.Role;



public interface Roles extends JpaRepository<Role, Long> {

	public List<Role> findByRoleContaining(String login);
	
	
}
