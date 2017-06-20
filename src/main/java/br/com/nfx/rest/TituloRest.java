package br.com.nfx.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.nfx.model.Titulo;
import br.com.nfx.repository.Titulos;

@Component
@Path("titulos")
public class TituloRest {
	
	@Autowired
	private Titulos titulos;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String exibir(){
		
		List<Titulo> listaTitulos = titulos.findAll();
		Gson json = new Gson();
		
		return json.toJson(listaTitulos);
	}
}
