package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.ICursodao;
import com.upc.dto.Curso;
import com.upc.factory.Factory;

public class cursoModel {
	ICursodao cudao = null;
	
	public cursoModel(){
		cudao = Factory.getInstance().getCursodao();
	}
	
	public void registrarCurso(Curso cu) throws SQLException{
		cudao.create(cu);
	}
	
	public void eliminarCurso(int codigo) throws SQLException{
		cudao.delete(codigo);
	}
	
	public void actualizarCurso(Curso cu) throws SQLException{
		cudao.update(cu);
	}
	
	public Curso buscarCurso(int codigo) throws SQLException{
		return cudao.get(codigo);
	}
	
	public List<Curso>  listarCursos() throws SQLException{
		
		return cudao.getAll();
	}

}
