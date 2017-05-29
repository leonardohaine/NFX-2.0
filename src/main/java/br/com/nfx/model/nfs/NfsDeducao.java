package br.com.nfx.model.nfs;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="nfs_deducao")
@Data
public class NfsDeducao implements Serializable
{
  private static final long serialVersionUID = 1L;

  //@EmbeddedId
  //private NfsDeducaoPk nfsDeducaoPk;
  
  @Id
  @Column(name="id")
  private String id;
  
  @Column(name="VALORDEDUZIR")
  private BigDecimal valorDeduzir;

}