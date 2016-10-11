package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.ITemariodao;
import com.upc.dto.Temario;
import com.upc.factory.Factory;

public class temaModel {
	ITemariodao tdao =null;
	
	public temaModel(){
		tdao =Factory.getInstance().getTemariodao();
	}
	
	public void registrarTema(Temario t) throws SQLException{
		tdao.create(t);
	}
	
	public void actualizarTema(Temario t) throws SQLException{
		tdao.update(t);
	}
	public void eliminarTema(int codigo) throws SQLException{
		tdao.delete(codigo);
	}
	
	public Temario buscarTema(int codigo) throws SQLException{
		return tdao.get(codigo);
	}
	public List<Temario> listarTemas() throws SQLException{
		return tdao.getAll();
	}
	

}
