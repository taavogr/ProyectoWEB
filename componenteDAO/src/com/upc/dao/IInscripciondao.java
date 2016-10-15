package com.upc.dao;

import java.sql.SQLException;
import java.util.List;

import com.upc.dto.Inscripcion;

public interface IInscripciondao extends
	ICruddao<Inscripcion>, IRowmapper<Inscripcion>{
	
	List<Inscripcion> getInsUser (int codigo)throws SQLException;
}