package br.com.nfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nfx.model.Empresa;


@Repository
public interface Empresas extends JpaRepository<Empresa, Long> {

}
