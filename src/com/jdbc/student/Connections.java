package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	public static final String URL="jdbc:mysql://localhost:/school";
	public static final String USER="root";
	public static final String PASS="1212";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(URL,USER,PASS);
		return con;
	}
	

}
