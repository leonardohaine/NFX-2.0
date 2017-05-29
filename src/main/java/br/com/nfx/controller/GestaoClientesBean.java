package br.com.nfx.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.nfx.model.Cliente;
import br.com.nfx.repository.Clientes;
import br.com.nfx.service.CadastroClienteService;
import br.com.nfx.util.FacesMessages;
import lombok.Data;

@Named
@ViewScoped
@Data
public class GestaoClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Clientes clientes;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	@Autowired
	private FacesMessages messages;
	
	private List<Cliente> todosClientes;
	private Cliente clienteEdicao = new Cliente();
	private Cliente clienteSelecionado;
	
	private List<String> listCidade = new ArrayList<String>();
	private Integer ibgeCidade;
	
	public void prepararNovoCadastro() {
		clienteEdicao = new Cliente();
	}
	
	public void salvar() {
		cadastroCliente.salvar(clienteEdicao);
		consultar();
		
		messages.info("Cliente salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:clientes-table"));
	}
	
	public void excluir() {
		cadastroCliente.excluir(clienteSelecionado);
		clienteSelecionado = null;
		
		consultar();
		
		messages.info("Cliente excluído com sucesso!");
	}
	
	public void consultar() {
		todosClientes = clientes.findAll();
	}

	public void selecionarCidade(){
		System.out.println("getCidade: " + clienteEdicao.getUf());
		listCidade = cadastroCliente.getCidade(clienteEdicao.getUf());
		//RequestContext.getCurrentInstance().update("formCli:municipio");
	}
	
	public void selecionarIbgeCidade(){
		System.out.println("getIbgeCidade: " + clienteEdicao.getMunicipio());
		ibgeCidade = Integer.valueOf(cadastroCliente.getIbgeCidade(clienteEdicao.getUf(), clienteEdicao.getMunicipio()));
		clienteEdicao.setCodigoMunicipio(ibgeCidade);
		System.out.println(ibgeCidade);
		//RequestContext.getCurrentInstance().update("formCli:municipio");
	}
	
	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}
	

	public Cliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(Cliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
}