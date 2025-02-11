package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Car {
	
	public void insertRecord() throws Exception {
		//register and load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		//create statements
		Statement s = c.createStatement();
		
		//Execute query for inserting the data
		s.executeUpdate("insert into car(id, comp_name, model, price, speed) values(105, 'Tata', 'Punch', 600000, '90km/h')");
		
		System.out.println("Data is inserted Successfully");
		
		//close all the connections
		c.close();
		
	}
	
	public void updateRecord() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		//create Statement
		Statement s = c.createStatement();
		
		//Execute query to update data 
		s.executeUpdate("update car set comp_name = 'Toyoto', model= 'Fortuner' where id =102 ");
		
		System.out.println("Data is Updated Successfully.");
		
		//close all the connection
		s.close();
		c.close();
		
	}
	
	public void fetchAllRecord() throws Exception {

		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		//create Statement
		Statement s = c.createStatement();
		
		//Execute query to fetch data 
		ResultSet rs = s.executeQuery("select * from car");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
		}
		
		//close all connection
		c.close();
		
	}
	
	public void deleteRecord() throws Exception {
		//register and load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		//create Statement
		Statement s = c.createStatement();
		
		//execute query to delete record
		s.executeUpdate("delete from car where id =101");
		System.out.println("Data is deleted Successfully.");
		
		//close all the connection
		c.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		Car c = new Car();
//		c.insertRecord(); 
//		c.updateRecord();
//		c.fetchAllRecord();
		c.deleteRecord();
	}
}
