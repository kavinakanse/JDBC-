package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Project {
	public void insertData() throws Exception {
		// register and load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// statement or preparedStatement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("insert into project(id, name, duration) values(5, 'chatbot', 1)");

		System.out.println("Data inserted successfully");

		// close all connections
		s.close();
		c.close();
	}

	public void updateData() throws Exception {
		// register and load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("update project set name= 'netflix clone' where id =1");

		System.out.println("Data is updated Successfully.");

		// close all connection
		s.close();
		c.close();
	}

	public void getAllData() throws Exception {
		// register and load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		ResultSet rs = s.executeQuery("select * from project");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2)+" "+ rs.getInt(3));
		}

		// close all connection
		s.close();
		c.close();
	}

	public void deleteData() throws Exception {
		// register and load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");

		// create Statement
		Statement s = c.createStatement();

		// execute query
		s.executeUpdate("delete from project where id = 1");

		System.out.println("Data is deleted Successfully.");

		// close all connection
		s.close();
		c.close();
	}

	public static void main(String[] args) throws Exception {
		Project p = new Project();
//		p.insertData();
//		p.updateData();
//		p.getAllData();
		p.deleteData();
	}
}
