package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.IUsuariodao;
import com.upc.dto.Usuario;
import com.upc.factory.Factory;

public class usuarioModel {
	
	IUsuariodao udao = null;

	public usuarioModel() {
		udao = Factory.getInstance().getUsuariodao();
	}
	
	
	public void registrarUsuario(Usuario usu) throws SQLException
	{
		udao.create(usu);
	}
	
	public void eliminarUsuario(int codigo) throws SQLException{
		udao.delete(codigo);
	}
	
	public void actualizarUsuario(Usuario usu) throws SQLException{
		udao.update(usu);
	}
	
	public Usuario buscarUsuario(int codigo) throws SQLException{
		
		return udao.get(codigo);
	}
	
	public List<Usuario> listarUsuarios() throws SQLException{
		
		return udao.getAll();
	}

}
