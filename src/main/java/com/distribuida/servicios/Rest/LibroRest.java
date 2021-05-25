package com.distribuida.servicios.Rest;

import java.util.List;

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

import com.distribuida.db.Libro;
import com.distribuida.servicios.ServicioLibro;



@Path("/libros")
@ApplicationScoped
public class LibroRest {

	@Inject
	private ServicioLibro service_libro;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Libro> listarLibros() {
		System.out.println("ingreso SERVICIO REST1");
		return service_libro.todoslibros();

	}
	
	
	@GET
	@Path("/autor/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Libro> listarlibro(@PathParam(value="id") int id){
		return service_libro.listarLibrosAutor(id);
		
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Libro bucarByLibro(@PathParam(value = "id") int id) {
		return service_libro.buscarLibro(id);

	};
	
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void insertar(Libro lib) {
		service_libro.CreateLibro(lib);
				
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void eliminarAut(@PathParam(value="id") int id) {
		service_libro.deleteLibro(id);	
	}

	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public void updateAutor(Libro aut) {
		service_libro.actualizarBook(aut);
	}
	
}
