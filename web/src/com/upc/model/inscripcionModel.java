package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.IInscripciondao;
import com.upc.dto.Inscripcion;
import com.upc.factory.Factory;

public class inscripcionModel {
	IInscripciondao imodel = null;
	
	public inscripcionModel(){
		imodel =Factory.getInstance().getInscripciondao();
	}
	
	public void registrarIncripcion(Inscripcion in) throws SQLException{
		imodel.create(in);
	}
	
	public void eliminarInscripcion(int codigo) throws SQLException{
		imodel.delete(codigo);
	}
	
	public Inscripcion buscarInscripcion(int codigo) throws SQLException{
		return imodel.get(codigo);
	}
	
	public List<Inscripcion> listarIncripciones() throws SQLException{
		return imodel.getAll();
	}
	
	public List<Inscripcion> listarInsxuser(int codigo) throws SQLException{
		return imodel.getInsUser(codigo);
	}
		

}
