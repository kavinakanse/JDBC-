package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dog {
	public void insertData() throws Exception {
		// register and load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("insert into dog(id, name, breed, colour) values(5, 'sheero', 'pug', 'white')");

		System.out.println("Data is inserted Successfully.");

		// close all connection
		s.close();
		c.close();
	}

	public void updateData() throws Exception {
		// register and load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("update dog set colour = 'black' where id =2");

		System.out.println("Data is updated Successfully.");

		// close all connection
		s.close();
		c.close();
	}

	public void getAllData() throws Exception {
		// register and load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		ResultSet rs = s.executeQuery("select * from dog");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}

		// close all connection
		s.close();
		c.close();
	}

	public void deleteData() throws Exception {
		// register and load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("delete from dog where id = 3");

		System.out.println("Data is deleted Successfully.");

		// close all connection
		s.close();
		c.close();
	}
	
	public static void main(String[] args) throws Exception {
		Dog d = new Dog();
//		d.insertData();
//		d.updateData();
//		d.getAllData();
		d.deleteData();
	}
}
