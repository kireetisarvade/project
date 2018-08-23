package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementExample {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
			//Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("insert into employe values(?,?,?)");
			Scanner scr = new Scanner(System.in);
			String choice;
			do
			{
				System.out.println("Enter EmployeId");
				int eid= scr.nextInt();
				System.out.println("Enter EmployeName");
				String ename= scr.next();
				System.out.println("Enter Employesalary");
				float esalary= scr.nextFloat();			
				
			pst.setInt(1, eid);
            pst.setString(2,ename);
            pst.setFloat(3,esalary);
            
            int result=pst.executeUpdate();
			///int result=st.executeUpdate("insert into employe values("+eid+",'"+ename+"',"+esalary+")");
				System.out.println(result+" record(s) inserted");
				System.out.println("Do u want to insert another record..{Y/N}");
				choice=scr.next();
			}
			while(choice.equalsIgnoreCase("Y"));
			scr.close();			
			con.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
			
			
			
	}

}
