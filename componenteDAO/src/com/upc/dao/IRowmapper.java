package com.upc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowmapper<T> {
	T mapRow(ResultSet rs) throws SQLException;
}
