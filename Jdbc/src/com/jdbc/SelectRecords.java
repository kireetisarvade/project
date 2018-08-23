package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecords {


		public static void main(String[] args) {
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstsql","root","Kireeti@1");
				Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("select idemploye,Employesalary from employe");
				
			ResultSetMetaData md=rs.getMetaData();
			for(int i=1;i<=md.getColumnCount();i++)
			{
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println("\n");
			System.out.println("---------------------------------------------------------");
			while(rs.next())
			{
				for(int i=1;i<=md.getColumnCount();i++)
				{
					System.out.print(rs.getString(i)+"\t \t");
				}				
				System.out.println();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
				
				
				
			}
			catch(SQLException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			
			
		}
}
