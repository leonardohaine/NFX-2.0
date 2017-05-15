package br.com.nfx.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nfx.model.Empresa;
import br.com.nfx.repository.Empresas;

@Service
public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Empresas empresas;
	
	@Transactional
	public void salvar(Empresa empresa) {
		empresas.save(empresa);
	}
	
	@javax.transaction.Transactional
	public void excluir(Empresa empresa) {
		empresas.delete(empresa);
	}

}