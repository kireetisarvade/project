package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class GetProcedureExample {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
			CallableStatement cst=con.prepareCall("{ call get_employe_proc(?,?,?)}");
			
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter EmployeId");
			int eid= scr.nextInt();
			
			cst.setInt(1,eid);
			
			cst.registerOutParameter(2,Types.VARCHAR);
			cst.registerOutParameter(3, Types.FLOAT);
			
			cst.execute();
			
			String name= cst.getString(2);
			float sal=cst.getFloat(3);
			if(name!=null)
			{
			System.out.println(name+"\t"+sal);
			}
			else {
				System.out.println("no records with this id:");
			}
			
			con.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
