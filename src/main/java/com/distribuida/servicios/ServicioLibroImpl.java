package com.distribuida.servicios;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.db.Libro;
import com.distribuida.mapper.LibroMapper;

@ApplicationScoped
public class ServicioLibroImpl implements ServicioLibro{
 @Inject
 private LibroMapper mapperlibro;

@Override
public ArrayList<Libro> todoslibros() {
	// TODO Auto-generated method stub
	return mapperlibro.listarlibros();
}

@Override
public ArrayList<Libro> listarLibrosAutor(int id) {
	// TODO Auto-generated method stub
	return mapperlibro.buscarPorAutor(id);
}

@Override
public Libro buscarLibro(int id) {
	// TODO Auto-generated method stub
	return mapperlibro.buscarLibro(id);
}

@Override
public void CreateLibro(Libro aut) {
	mapperlibro.crearLibro(aut);
	
}

@Override
public void deleteLibro(int id) {
	mapperlibro.eliminarLibro(id);
	
}

@Override
public void actualizarBook(Libro aut) {
	mapperlibro.actualizarLibro(aut);
	
}
 
 


}
