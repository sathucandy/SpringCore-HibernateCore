package com.sarthak.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false&serverTimezone=UTC";
		String user = "sarthak";
		String pass = "Sonarthak@09";
		try {
			System.out.println("Conntecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Succesful");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
