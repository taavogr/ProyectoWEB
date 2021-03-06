package com.upc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconexcion;
import com.upc.dto.Categoria;
import com.upc.dao.ICategoriadao;

public class Categoriadao implements ICategoriadao {

	@Override
	public void create(Categoria o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_categoria(?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Categoria o) throws SQLException {
		// TODO Auto-generated method stub
		String update = "{call sp_update_categoria(?,?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);
		CallableStatement cs = cn.prepareCall(update);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdCategoria());
		cs.setString(3, o.getNombre());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}

	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "{call sp_delete_categoria(?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(delete);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, codigo);

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("Eliminado!")) {
			throw new SQLException(estado);
		}

	}

	@Override
	public Categoria get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_get_categoria(?)}";
		Connection cn = Dbconexcion.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		cs.setInt(1, codigo);

		ResultSet rs = cs.executeQuery();
		if (rs.next()) {
			mapRow(rs);
		}

		return mapRow(rs);
	
	}

	@Override
	public List<Categoria> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Categoria> lista = new ArrayList<>();
		String query = "{call sp_list_categoria()}";

		Connection cn = Dbconexcion.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Categoria mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();
		
		c.setIdCategoria(rs.getInt(1));
		c.setNombre(rs.getString(2));
		
		return c;
	}

}
