package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecords {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
			Statement st=con.createStatement();
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter Range");
			
			float salary= scr.nextFloat();
			
			int result=st.executeUpdate("delete from Employe where Employesalary>"+salary);
			System.out.println(result+" records Updated");
			scr.close();
			
			
	
	
			
			
		}
			catch(SQLException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			
			
		}
}
