package com.upc.model;

import java.sql.SQLException;

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
		

}
