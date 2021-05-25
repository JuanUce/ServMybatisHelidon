package com.distribuida.mapper;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.cdi.Mapper;

import com.distribuida.db.Libro;

@Mapper
public interface LibroMapper {

	
	@Select("select * from Libro")
	public ArrayList<Libro> listarlibros();
	
	@Select("select * from Libro where autor_id=#{id}")
	public ArrayList<Libro> buscarPorAutor(@PathParam("id") int id);
	
	@Select("select * from Libro where id=#{id} ")
	public Libro buscarLibro(@PathParam("id") int id);
	
	@Insert("insert into Libro (isbn,title,autor_id)values (#{isbn},#{title},#{autor_id})")
	public void crearLibro(Libro libro);
	
	@Delete("Delete from Libro where id=#{id}")
	public void eliminarLibro(@PathParam("id") int id);
	
	@Update("Update Libro set isbn=#{isbn},title=#{title},autor_id=#{autor_id} where id=#{id}")
	public void actualizarLibro(Libro libro);
}
