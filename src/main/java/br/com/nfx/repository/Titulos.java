package br.com.nfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nfx.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {

}
