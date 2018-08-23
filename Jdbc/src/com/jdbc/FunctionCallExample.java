package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class FunctionCallExample {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
			CallableStatement cst=con.prepareCall("{ ?=call calculate_allowance(?,?)}");
			
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter EmployeId");
			int eid= scr.nextInt();
			System.out.println("enter Percentage");
			float percentage= scr.nextFloat();
			
			
			cst.setInt(2, eid);
			cst.setFloat(3,percentage );
			
			cst.registerOutParameter(1,Types.FLOAT);
			
			
			cst.execute();
			
			
			float allowance=cst.getFloat(1);
			if(allowance!=0.0)
			{
				System.out.println(allowance);
			}
			else
			{
				System.out.println("No data");
			}
			
			
			con.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
}}
