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
		String update = "{call sp_update_inscripcion(?,?,?,?,?)}";

		Connection cn = Dbconexcion.getInstance();

		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(update);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdInscripcion());
		cs.setString(3, o.getFecha_inscripcion());
		cs.setInt(4, o.getIdUsuario().getIdUsuario());
		cs.setInt(5, o.getIdCurso().getIdCurso());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("Actualizado!")) {
			throw new SQLException(estado);
		}
		
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "{call sp_delete_inscripcion(?,?)}";

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
	public Inscripcion get(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_get_inscripcion(?)}";
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
