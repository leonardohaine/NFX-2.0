package br.com.nfx.model;

public enum CategoriaTitulo {

	DIVIDAS("Dívidas"),
	EMPRESTIMOS("Empréstimos"),
	SALARIOS("Salários"),
	OUTROS("Outros"),
	ESCRITORIO("Escritório"),
	IMPOSTOS_TAXAS("Impostos e taxas")
	;
	
	
	private String descricao;
	
	CategoriaTitulo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
