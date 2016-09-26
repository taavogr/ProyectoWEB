package com.upc.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICruddao<T> {
	void create(T o) throws SQLException;

	void update(T o) throws SQLException;

	void delete(int codigo) throws SQLException;

	T get(int codigo) throws SQLException;

	List<T> getAll() throws SQLException;
}
