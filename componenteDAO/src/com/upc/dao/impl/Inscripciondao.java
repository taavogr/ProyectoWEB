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
import com.upc.dto.Inscripcion;
import com.upc.dto.Usuario;
import com.upc.dao.IInscripciondao;

public class Inscripciondao implements IInscripciondao{

	@Override
	public void create(Inscripcion o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_inscripcion(?,?,?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getFecha_inscripcion());
		cs.setInt(3, o.getIdUsuario().getIdUsuario());
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
	public void update(Inscripcion o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inscripcion get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inscripcion> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Inscripcion> lista = new ArrayList<>();
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
	public Inscripcion mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Inscripcion i = new Inscripcion();
		Usuario u = new Usuario();
		Curso cu = new Curso();
		Categoria c = new Categoria();
		
		i.setIdInscripcion(rs.getInt(1));
		i.setFecha_inscripcion(rs.getString(2));
		
		u.setIdUsuario(rs.getInt(3));
		u.setNombre(rs.getString(4));
		u.setDNI(rs.getString(5));
		u.setCorreo(rs.getString(6));
		u.setUsuario(rs.getString(7));
		u.setClave(rs.getString(8));
		u.setRol(rs.getString(9));
		
		i.setIdUsuario(u);
		
		cu.setIdCurso(rs.getInt(4));
		cu.setNombre(rs.getString(5));
		
		c.setIdCategoria(rs.getInt(6));
		c.setNombre(rs.getString(7));
		
		cu.setIdCategoria(c);
		cu.setMonto(rs.getString(8));
		
		i.setIdCurso(cu);
		
		return i;
	}

}
