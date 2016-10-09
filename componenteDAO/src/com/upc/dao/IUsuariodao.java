package com.upc.dao;

import java.sql.SQLException;

import com.upc.dto.Usuario;

public interface IUsuariodao extends
	ICruddao<Usuario>,IRowmapper<Usuario>{
	
	 Usuario autenticar(String nick,String password) throws SQLException;

}
