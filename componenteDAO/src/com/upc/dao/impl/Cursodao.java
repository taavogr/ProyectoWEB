package com.upc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconexcion;
import com.upc.dto.Categoria;
import com.upc.dto.Curso;
import com.upc.dao.ICursodao;

public class Cursodao implements ICursodao{

	@Override
	public void create(Curso o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_curso(?,?,?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setInt(3, o.getIdCategoria().getIdCategoria());
		cs.setString(4, o.getMonto());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Curso o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Curso> lista = new ArrayList<>();
		String query = "{call sp_list_curso()}";

		Connection cn = Dbconexcion.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Curso mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Curso cu = new Curso();
		Categoria c = new Categoria();
		
		cu.setIdCurso(rs.getInt(1));
		cu.setMonto(rs.getString(2));
		
		c.setIdCategoria(rs.getInt(3));
		c.setNombre(rs.getString(4));
		
		cu.setIdCategoria(c);
		cu.setMonto(rs.getString(5));
		
		return cu;
	}

}
