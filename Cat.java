package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cat {
	public void insertData() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");
		
		//create statement
		Statement s = c.createStatement();
		
		//execute query
		s.executeUpdate("insert into cat(id, name, breed, colour) values(5, 'mini', ' ragdoll', 'brown')");
		
		System.out.println("Data is inserted successfully.");
		
		//close all the connection
		s.close();
		c.close();
	}
	
	public void updateData() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");
		
		//create statement
		Statement s = c.createStatement();
		
		//execute query
		s.executeUpdate("update cat set name = 'kittu' where id = 3");
		
		System.out.println("Data is updated successfully.");
		
		//close all the connection
		s.close();
		c.close();
	}
	
	public void getAllData() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		//create statement
		Statement s = c.createStatement();
		
		//execute query
		ResultSet rs = s.executeQuery("select * from cat" );
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		
		//close all connection
		s.close();
		c.close();
		
	}
	
	public void deletedData() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");
		
		//create statement
		Statement s = c.createStatement();
		
		//execute query
		s.executeUpdate("delete from cat where id =2");
		
		System.out.println("Data is deleted successfully.");
		
		//close all the connection
		s.close();
		c.close();
	}
	
	public static void main(String[] args) throws Exception {
		Cat c = new Cat();
//		c.insertData();
//		c.updateData();
//		c.getAllData();
		c.deletedData();
	}
}
