package com.programacion.Principal;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path(value="/")
public class HolaMundo {
	
	@GET
	@Path(value="/hola")
	public String hola() {
		return "hola"+  LocalDateTime.now();
		
		
	}

}
