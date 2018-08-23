package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CallableStatementProcedure {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
			CallableStatement cst=con.prepareCall("{ call add_employe_proc(?,?,?)}");
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter EmployeId");
			int eid= scr.nextInt();
			System.out.println("Enter EmployeName");
			String ename= scr.next();
			System.out.println("Enter Employesalary");
			float esalary= scr.nextFloat();		
			
			cst.setInt(1,eid);
			cst.setString(2,ename);
			cst.setFloat(3,esalary);
			
			cst.execute();
			System.out.println("Inserted sucussfully");
			
			
			con.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		

	}

}
