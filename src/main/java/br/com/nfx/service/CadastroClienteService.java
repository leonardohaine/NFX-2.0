package br.com.nfx.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nfx.model.Cliente;
import br.com.nfx.repository.Cidades;
import br.com.nfx.repository.Clientes;

@Service
public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cliente cliente) {
		clientes.save(cliente);
	}
	
	@javax.transaction.Transactional
	public void excluir(Cliente cliente) {
		clientes.delete(cliente);
	}
	
	public List<String> getCidade(String uf) {
		return cidades.findBySiglaUf(uf);
	}
	
	public String getIbgeCidade(String uf, String descricaoMunicipio) {
		return cidades.findBySiglaUfAndDescricaoMunicipio(uf, descricaoMunicipio);
	}

}