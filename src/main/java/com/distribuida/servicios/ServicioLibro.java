package com.distribuida.servicios;

import java.util.ArrayList;

import com.distribuida.db.Libro;

public interface ServicioLibro {

	
	public ArrayList<Libro> todoslibros();
	
	public ArrayList<Libro> listarLibrosAutor(int id);
	
	public Libro buscarLibro(int id);
	
	public void CreateLibro(Libro aut);
	
	public void deleteLibro(int id);
	
	public void actualizarBook(Libro aut);
	
	
}
