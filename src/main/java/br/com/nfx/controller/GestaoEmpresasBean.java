package br.com.nfx.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.nfx.model.Empresa;
import br.com.nfx.model.TipoEmpresa;
import br.com.nfx.repository.Empresas;
import br.com.nfx.service.CadastroEmpresaService;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

@Named
@ViewScoped
@Data
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Empresas empresas;
	
	@Autowired
	private CadastroEmpresaService cadastroEmpresa;
	
	@Autowired
	private FacesMessages messages;
	
	private List<Empresa> todasEmpresas;
	private Empresa empresaEdicao = new Empresa();
	private Empresa empresaSelecionada;
	
	public void prepararNovoCadastro() {
		empresaEdicao = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresa.salvar(empresaEdicao);
		consultar();
		
		messages.info("Empresa salva com sucesso!");
		Messages.addGlobalInfo("mensagem omni faces");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		cadastroEmpresa.excluir(empresaSelecionada);
		empresaSelecionada = null;
		
		consultar();
		
		messages.info("Empresa excluída com sucesso!");
	}
	
	public void consultar() {
		todasEmpresas = empresas.findAll();
	}

	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}
	
	public TipoEmpresa[] getTiposEmpresas() {
		return TipoEmpresa.values();
	}

	public Empresa getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void setEmpresaEdicao(Empresa empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	
}