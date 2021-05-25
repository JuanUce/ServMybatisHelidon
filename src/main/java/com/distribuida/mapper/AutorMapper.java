package com.distribuida.mapper;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.cdi.Mapper;

import com.distribuida.db.Autor;

@Mapper
public interface AutorMapper {

	@Select("select * from autor")
	public ArrayList<Autor> listarAutores();
	
	
	@Select ("select * from autor where id=#{id}")
	public Autor buscarPorAutor(@PathParam(value="id")int id);
	
	@Insert("insert into (edad,genero, nombre) values (#{edad},#{genero},#{nombre})")
	public void crearAutor(Autor autor); 
	
	@Delete("delete from autor where id=#{id}")
	public void eliminarAutor(@PathParam("id") int id);
	
	@Update("update autor set edad=#{edad},genero=#{genero},nombre=#{nombre} where id=#{id}")
	public void actualizar(Autor autor);
	
	
	
}
