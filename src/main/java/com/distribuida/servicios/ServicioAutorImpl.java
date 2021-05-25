package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.db.Autor;
import com.distribuida.db.Libro;
import com.distribuida.mapper.AutorMapper;
import com.distribuida.mapper.LibroMapper;
@ApplicationScoped
public class ServicioAutorImpl implements ServicioAutor{

	@Inject
	private AutorMapper mapperautor;
	@Inject
	private LibroMapper mapperlibro;
	
	@Override
	public ArrayList<Autor> listarAutor() {
	System.out.println("Ingreso servicio autor");		
		return mapperautor.listarAutores();
	}

	@Override
	public Autor buscarPorAutor(int id) {
		// TODO Auto-generated method stub
		return mapperautor.buscarPorAutor(id);
	}

	@Override
	public void CreateAutor(Autor aut) {
		mapperautor.crearAutor(aut);
		
	}

	@Override
	public void deleteAutor(int id) {
		ArrayList<Libro> li= new ArrayList<Libro>();
		int id_temp;
		li=mapperlibro.buscarPorAutor(id);
		if (!li.isEmpty()) {
			for (int i = 0; i < li.size(); i++) {
				id_temp=li.get(i).getId();
				mapperlibro.eliminarLibro(id_temp);
				mapperautor.eliminarAutor(id);
			}
		}else {
			
			mapperautor.eliminarAutor(id);
		}
		
	}

	@Override
	public void actualizarAut(Autor aut) {
		mapperautor.actualizar(aut);
		
	}

}
