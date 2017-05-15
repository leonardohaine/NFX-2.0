package br.com.nfx.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.nfx.model.CategoriaTitulo;
import br.com.nfx.model.StatusTitulo;
import br.com.nfx.model.Titulo;
import br.com.nfx.repository.Titulos;
import br.com.nfx.service.CadastroTituloService;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

@Named
@ViewScoped
@Data
public class GestaoTitulosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Titulos titulos;
	
	@Autowired
	private CadastroTituloService cadastroTitulo;
	
	@Autowired
	private FacesMessages messages;
	
	private List<Titulo> todosTitulos;
	private List<Titulo> titulosFiltrados;
	
	private Titulo tituloEdicao = new Titulo();
	private Titulo tituloSelecionado;
	
	public void prepararNovoCadastro() {
		tituloEdicao = new Titulo();
	}
	
	public void salvar() {
		cadastroTitulo.salvar(tituloEdicao);
		consultar();
		
		messages.info("Título salvo com sucesso!");
		//Messages.addGlobalInfo("mensagem omni faces");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:titulos-table"));
	}
	
	public void excluir() {
		cadastroTitulo.excluir(tituloSelecionado);
		tituloSelecionado = null;
		
		consultar();
		
		messages.info("Título excluída com sucesso!");
	}
	
	public void consultar() {
		todosTitulos = titulos.findAll();
	}
	
	public void receber() {
		
		tituloEdicao.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(tituloEdicao);
		consultar();
		
		messages.info("Título recebido com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:titulos-table"));
	}

	public List<Titulo> getTodosTitulos() {
		return todosTitulos;
	}
	
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	public List<CategoriaTitulo> todasCategoriasTitulo() {
		return Arrays.asList(CategoriaTitulo.values());
	}

	public Titulo getTituloEdicao() {
		return tituloEdicao;
	}

	public void setTituloEdicao(Titulo tituloEdicao) {
		this.tituloEdicao = tituloEdicao;
	}

	public Titulo getTituloSelecionado() {
		return tituloSelecionado;
	}

	public void setTituloSelecionado(Titulo tituloSelecionado) {
		this.tituloSelecionado = tituloSelecionado;
	}
	
}