package br.com.nfx.model.nfs;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="nfs_item")
@Data
public class NfsItem implements Serializable
{
  private static final long serialVersionUID = 1L;

  //@EmbeddedId
  //private NfsItemPk nfsItemPk;
  
  @Id
  @Column(name="id")
  private String id;

  @Column(name="DISCSERV")
  private String discriminacaoServico;

  @Column(name="QTDE")
  private Long quantidade;

  @Column(name="VALUNIT")
  private BigDecimal valorUnitario;

  @Column(name="VALTOTAL")
  private BigDecimal valorTotal;

  @Column(name="UNIDMED")
  private String unidadeMedida;

  @Column(name="VALDEDUZITEM")
  private BigDecimal valorDeduzirItem;

 
}
