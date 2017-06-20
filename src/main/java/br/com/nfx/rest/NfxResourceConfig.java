package br.com.nfx.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class NfxResourceConfig extends ResourceConfig {

	public NfxResourceConfig(){
		packages("br.com.nfx.rest");
	}
}
