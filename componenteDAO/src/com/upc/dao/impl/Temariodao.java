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
import com.upc.dto.Temario;
import com.upc.dao.ITemariodao;

public class Temariodao implements ITemariodao{

	@Override
	public void create(Temario o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_temario(?,?,?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getDescripcion());
		cs.setInt(4, o.getIdCurso().getIdCurso());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Temario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Temario get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Temario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Temario> lista = new ArrayList<>();
		String query = "{call sp_list_temario()}";

		Connection cn = Dbconexcion.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Temario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Temario t = new Temario();
		Curso cu = new Curso();
		Categoria c = new Categoria();
		
		t.setIdTemario(rs.getInt(1));
		t.setNombre(rs.getString(2));
		t.setDescripcion(rs.getString(3));
		
		cu.setIdCurso(rs.getInt(4));
		cu.setNombre(rs.getString(5));
		
		c.setIdCategoria(rs.getInt(6));
		c.setNombre(rs.getString(7));
		
		cu.setIdCategoria(c);
		cu.setMonto(rs.getString(8));
		
		t.setIdCurso(cu);
		
		return t;
	}

}
