package com.distribuida.servicios;

import java.util.ArrayList;

import com.distribuida.db.Autor;

public interface ServicioAutor {
   
	public ArrayList<Autor> listarAutor();
	
	public Autor buscarPorAutor(int id);
	
	public void CreateAutor(Autor aut);
	
	public void deleteAutor(int id);
	
	public void actualizarAut(Autor aut);
   
   
}
