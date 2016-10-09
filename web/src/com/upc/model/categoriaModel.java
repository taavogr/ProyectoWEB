package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.ICategoriadao;
import com.upc.dto.Categoria;
import com.upc.factory.Factory;

public class categoriaModel {
	
	ICategoriadao cdao=null;
	
	public categoriaModel(){
		cdao = Factory.getInstance().getCategoriadao();
	}
	
	public void registrarCategoria(Categoria c) throws SQLException{
		cdao.create(c);
	}
	
	public void eliminarCategoria(int codigo) throws SQLException{
		cdao.delete(codigo);
	}
	public void actualizarCategoria(Categoria c) throws SQLException{
		cdao.update(c);
	}
	
	public Categoria buscarCategoria(int codigo) throws SQLException{
		return cdao.get(codigo);
	}
	
	public List<Categoria> listarcategorias() throws SQLException{
		return cdao.getAll();
	}

}
