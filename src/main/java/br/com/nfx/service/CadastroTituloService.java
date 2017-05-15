package br.com.nfx.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nfx.model.Titulo;
import br.com.nfx.repository.Titulos;

@Service
public class CadastroTituloService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Titulos titulos;
	
	@Transactional
	public void salvar(Titulo titulo) {
		titulos.save(titulo);
	}
	
	@javax.transaction.Transactional
	public void excluir(Titulo titulo) {
		titulos.delete(titulo);
	}

}