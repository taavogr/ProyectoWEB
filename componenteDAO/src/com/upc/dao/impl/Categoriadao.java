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

	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
