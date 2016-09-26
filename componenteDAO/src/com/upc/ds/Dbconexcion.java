package com.upc.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconexcion {
	private static final String url = "jdbc:mysql://localhost:3306/dbcursosvirtual";//corregir nombre de la bd
    private static final String user = "root";
    private static final String passwd = "root";
    
    private static Connection con;
        
    private Dbconexcion(){}
    
   public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
            }
        }
        return con;
    }
}