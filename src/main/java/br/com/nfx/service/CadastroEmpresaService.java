package br.com.nfx.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nfx.model.Empresa;
import br.com.nfx.repository.Cidades;
import br.com.nfx.repository.Empresas;

@Service
public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Empresas empresas;
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Empresa empresa) {
		empresas.save(empresa);
	}
	
	@javax.transaction.Transactional
	public void excluir(Empresa empresa) {
		empresas.delete(empresa);
	}
	
	public List<String> getCidade(String uf) {
//		List<String> mun = ArrayList<String>;
//		for(String municipio : cidades.findBySiglaUf(uf)){
//			mun.add(municipio);
//		}
		
		return cidades.findBySiglaUf(uf);
	}
	
	public String getIbgeCidade(String uf, String descricaoMunicipio) {
		return cidades.findBySiglaUfAndDescricaoMunicipio(uf, descricaoMunicipio);
	}

}