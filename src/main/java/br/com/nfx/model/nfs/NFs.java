package br.com.nfx.model.nfs;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="nfs")
@Data
public class NFs implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="NUMERO_RPS")
  private Long numeroRps;

  @Column(name="VERSAO")
  private String versao;

  @Column(name="TPAMB")
  private String tipoAmbienteSistema;

  @Column(name="CODCID")
  private String codCidade;

  @Column(name="CNPJ_PREST")
  private String cnpjPrestador;

  @Column(name="INSC_PREST")
  private String inscricaoPrestador;

  @Column(name="SERIE_RPS")
  private String serieRps;

  @Column(name="DTEMIS_RPS")
  private String dataEmissaoRps;

  @Column(name="DTCOMP")
  private String dataCompetencia;

  @Column(name="TP_RPS")
  private String tipoRps;

  @Column(name="SIT_RPS")
  private String situacaoRps;

  @Column(name="NATOPER")
  private String naturezadaOperacao;

  @Column(name="MUNICPREST")
  private String municipioPrestacao;

  @Column(name="MUNICINCID")
  private String municipioIncidencia;

  @Column(name="PAISSERV")
  private String paisServico;

  @Column(name="DESC_RPS")
  private String descricaoRps;

  @Column(name="CODSERVINT")
  private String codigoServicoInterno;

  @Column(name="CODCNAE")
  private String codigoCnae;

  @Column(name="ITEMLISTSERV")
  private String itemListaServico;

  @Column(name="CODTRIBMUNIC")
  private String codigoTributacaoMunicipio;

  @Column(name="ALIQSERV")
  private BigDecimal aliquotaServicos;

  @Column(name="BASECALC")
  private BigDecimal baseCalculo;

  @Column(name="VALISS")
  private BigDecimal valorIss;

  @Column(name="TIPREC")
  private String tipoRecolhimento;

  @Column(name="VALISSRET")
  private BigDecimal valorIssRetido;

  @Column(name="RESPRET")
  private String responsavelRetencao;

  @Column(name="VALLIQNFSE")
  private BigDecimal valorLiquidoNfse;

  @Column(name="VALSERV")
  private BigDecimal valorServicos;

  @Column(name="VALPIS")
  private BigDecimal valorPis;

  @Column(name="VALCONFINS")
  private BigDecimal valorCofins;

  @Column(name="VALINSS")
  private BigDecimal valorInss;

  @Column(name="VALIR")
  private BigDecimal valorIr;

  @Column(name="VALCSLL")
  private BigDecimal valorCsll;

  @Column(name="OUTRET")
  private BigDecimal outrasRetencoes;

  @Column(name="VALDESCINCOND")
  private BigDecimal valorDescontoIncondicionado;

  @Column(name="VALDESCCOND")
  private BigDecimal valorDescontoCondicionado;

  @Column(name="RAZSOC_PREST")
  private String razaoSocialPrestador;

  @Column(name="END_PREST")
  private String enderecoPrestador;

  @Column(name="NUMEND_PREST")
  private String numeroEnderecoPrestador;

  @Column(name="COMPLEND_PREST")
  private String complementoEnderecoPrestador;

  @Column(name="BAI_PREST")
  private String bairroPrestador;

  @Column(name="CEP_PREST")
  private String cepPrestador;

  @Column(name="UF_PREST")
  private String ufPrestador;

  @Column(name="PAIS_PREST")
  private String paisPrestador;

  @Column(name="DDD_PREST")
  private String dddPrestador;

  @Column(name="TEL_PREST")
  private String telefonePrestador;

  @Column(name="EMAIL_PREST")
  private String emailPrestador;

  @Column(name="REGESPECTRIB")
  private String regimeEspecialTributacao;

  @Column(name="OPTSIMPNAC")
  private String optanteSimplesNacional;

  @Column(name="INCETIVCULT")
  private String incentivadorCultural;

  @Column(name="CPFCNPJ_TOMADOR")
  private String cpfCnpjTomador;

  @Column(name="INSCMUN_TOMADOR")
  private String inscricaoMunicipalTomador;

  @Column(name="INDCPFCNPJ")
  private String indicacaoCpfCnpj;

  @Column(name="INSCEST_TOMADOR")
  private String inscricaoEstadualTomador;

  @Column(name="RAZSOC_TOMADOR")
  private String razaoSocialTomador;

  @Column(name="TIPLOGRAD_TOMADOR")
  private String tipoLogradouroTomador;

  @Column(name="END_TOMADOR")
  private String enderecoTomador;

  @Column(name="NUMEND_TOMADOR")
  private String numeroEnderecoTomador;

  @Column(name="COMPLEND_TOMADOR")
  private String complementoEnderecoTomador;

  @Column(name="BAI_TOMADOR")
  private String bairroTomador;

  @Column(name="CID_TOMADOR")
  private String cidadeTomador;

  @Column(name="UF_TOMADOR")
  private String ufTomador;

  @Column(name="PAIS_TOMADOR")
  private String paisTomador;

  @Column(name="CEP_TOMADOR")
  private String cepTomador;

  @Column(name="EMAIL_TOMADOR")
  private String emailTomador;

  @Column(name="DDD_TOMADOR")
  private String dddTomador;

  @Column(name="TEL_TOMADOR")
  private String telefoneTomador;

  @Column(name="RAZSOCINTERM_SERV")
  private String razaoSocialIntermediarioServico;

  @Column(name="INSCMUNINTERM_SERV")
  private String inscricaoMunicipalIntermediarioServico;

  @Column(name="CPFCNPJINTERM_SERV")
  private String cpfCnpjIntermediarioServico;

  @Column(name="CODOBRA")
  private String codigodaObra;

  @Column(name="ART")
  private String art;

  @Column(name="SERIERPS_SUBST")
  private String serieRpsSubstituido;

  @Column(name="NUMRPS_SUBST")
  private String numeroRpsSubstituido;

  @Column(name="NUMPROCNAT")
  private String nroProcessoNatureza;

  @Column(name="LPTPLOGR")
  private String lpTpLogr;

  @Column(name="LPENDERECO")
  private String lpEndereco;

  @Column(name="LPNUMERO")
  private String lpNumero;

  @Column(name="LPCOMPL")
  private String lpCompl;

  @Column(name="LPBAIRRO")
  private String lpBairro;

  @Column(name="LPIBGEMUN")
  private BigDecimal lpIbgeMun;

  @Column(name="LPUF")
  private String lpUf;

  @Column(name="LPCEP")
  private String lpCep;

  @Column(name="LPINSCCADIMOVEL")
  private String lpInscCadImovel;

  @Column(name="ALIQUOTAPIS")
  private BigDecimal aliquotaPis;

  @Column(name="ALIQUOTACOFINS")
  private BigDecimal aliquotaCofins;

  @Column(name="ALIQUOTACSLL")
  private String aliquotaCsll;

  @Column(name="ALIQUOTAIR")
  private BigDecimal aliquotaIr;

  @Column(name="ALIQUOTAINSS")
  private BigDecimal aliquotaInss;

  @Column(name="MOTIVCANC")
  private String motivoCancelamento;

  @Column(name="AEDF")
  private String AEDF;

  @Column(name="CFPS")
  private String CFPS;

  @Column(name="DADOSADICIONAIS")
  private String dadosAdicionais;
  
}
