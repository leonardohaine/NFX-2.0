/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfx.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 *
 * @author Leonardo
 */

@Entity
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente",  allocationSize = 0)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty(message = "Tipo do cadastro não pode ser vazio")
    @Column(name = "tipo_cadastro")
    private String tipoCadastro;
    
    @Column(name = "razao_social")
    private String razaoSocial;
    
    @Column(name = "cnpj")
    private String cnpj;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    
    @Column(name = "inscricao_estadual_st")
    private String inscricaoEstadualST;
    
    @Column(name = "regime_tributario")
    private Long regimeTributario;
    
    @Column(name = "cnae_fiscal")
    private Long cnaeFiscal;
    
    @Column(name = "inscricao_municipal")
    private String inscricaoMunicipal;
    
    @Column(name = "suframa")
    private BigInteger suframa;
    
    @Column(name = "isento")
    private Boolean isento;
    
    @Column(name = "indicador_ie")
    private Integer indicadorIE;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "cep")
    private String cep;
    
    @Column(name = "logradouro")
    private String logradouro;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "bairro")
    private String bairro;
    
    @Column(name = "codigo_municipio")
    private Integer codigoMunicipio;
    
    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "codigo_pais")
    private Integer codigoPais;
    
    @Column(name = "pais")
    private String pais;
    
    @Column(name = "uf")
    private String uf;
    
    @Column(name = "telefone")
    private Long telefone;
    
    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "ativo")
    private Boolean ativo;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    /*public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
    	if(clienteId != null && cnpj != null && cnpj.length() == 14){
			 cnpj = (cnpj.substring(0, 2) + "." + 
				 	 cnpj.substring(2, 5) + "." +
				 	 cnpj.substring(5, 8) + "/" + 
				 	 cnpj.substring(8, 12) + "-" +
				 	 cnpj.substring(12, 14));
		} else if(clienteId != null && cnpj != null && cnpj.length() == 11){
			cnpj = (cnpj.substring(0, 3) + "." + 
					cnpj.substring(3, 6) + "." +
					cnpj.substring(6, 9) + "-" +
					cnpj.substring(9, 11));
		}
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
    	if(clienteId != null && cpf != null && cpf.length() == 11){
    		cpf = (cpf.substring(0, 3) + "." + 
					 cpf.substring(3, 6) + "." +
					 cpf.substring(6, 9) + "-" +
					 cpf.substring(9, 11));
		}
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualST() {
		return inscricaoEstadualST;
	}

	public void setInscricaoEstadualST(String inscricaoEstadualST) {
		this.inscricaoEstadualST = inscricaoEstadualST;
	}

	public Long getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(Long regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public Long getCnaeFiscal() {
		return cnaeFiscal;
	}

	public void setCnaeFiscal(Long cnaeFiscal) {
		this.cnaeFiscal = cnaeFiscal;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public BigInteger getSuframa() {
        return suframa;
    }

    public void setSuframa(BigInteger suframa) {
        this.suframa = suframa;
    }

    public Boolean getIsento() {
        return isento;
    }

    public Integer getIndicadorIE() {
		return indicadorIE;
	}

	public void setIndicadorIE(Integer indicadorIE) {
		this.indicadorIE = indicadorIE;
	}

	public void setIsento(Boolean isento) {
        this.isento = isento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    
    public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbtojava.Cliente[ cliente Id=" + id + " ]";
    }
    
}
