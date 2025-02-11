package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	
	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204", "root", "root");
		
		Statement s = c.createStatement();
		
		s.executeUpdate("insert into Employee(id, name, designation, salary, mob_no) values(5, 'kiran', 'Devloper', 65000, '9184567895')");

		System.out.println("Data inserted successfully");
		
		c.close();
	}
	
	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		Statement s = c.createStatement();
		
		s.executeUpdate("update employee set name = 'sanvi' where id = 2");
		
		System.out.println("Data is updated Successfully.");
		
		c.close();
	}
	
	public void fetchAllRecord() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root", "root");
		
		Statement s = c.createStatement();
		
		ResultSet rs = s.executeQuery("select * from employee");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
		}
	}
	
	public void deleteRecord() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk204","root","root");
		
		Statement s = c.createStatement();
		
		s.executeUpdate("delete from employee where id =4 ");
		
		System.out.println("Data is updated Successfully.");
		
		c.close();
	}
	
	public static void main(String[] args) throws Exception {
		Employee e = new Employee();
//		e.insertData();
//		e.updateData();
//		e.fetchAllRecord();
		e.deleteRecord();
	}
}
