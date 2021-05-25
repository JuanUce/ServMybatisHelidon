package com.distribuida.servicios.Rest;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.db.Autor;
import com.distribuida.servicios.ServicioAutor;


@Path("/autor")
@ApplicationScoped
public class AutorRest {
	
	@Inject
	private ServicioAutor service;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public ArrayList<Autor> listarAut(){		
		return service.listarAutor();
		
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Autor bucarByAutor(@PathParam(value = "id") int id) {
		return service.buscarPorAutor(id);

	};

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void insertar(Autor aut) {
		service.CreateAutor(aut);
			
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void eliminarAut(@PathParam(value="id") int id) {
		service.deleteAutor(id);	
	}

	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void updateAutor(Autor aut) {
		service.actualizarAut(aut);
	}
}
