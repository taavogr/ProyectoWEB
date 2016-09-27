package com.upc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconexcion;
import com.upc.dto.Usuario;
import com.upc.dao.IUsuariodao;

public class Usuariodao implements IUsuariodao{

	@Override
	public void create(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_usuario(?,?,?,?,?,?,?)}";
		String rol = "usuario";


		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getDNI());
		cs.setString(4, o.getCorreo());
		cs.setString(5, o.getUsuario());
		cs.setString(6, o.getClave());
		cs.setString(7, rol);

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		String query = "{call sp_list_usuario()}";

		Connection cn = Dbconexcion.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Usuario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
				
		u.setIdUsuario(rs.getInt(1));
		u.setNombre(rs.getString(2));
		u.setDNI(rs.getString(3));
		u.setCorreo(rs.getString(4));
		u.setUsuario(rs.getString(5));
		u.setClave(rs.getString(6));
		u.setRol(rs.getString(7));
		
		return u;
	}

}
