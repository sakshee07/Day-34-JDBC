package com.jdbc.bl;

import java.sql.SQLException;
import java.sql.*;

public class SQLQuery {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/payroll_service";
					
			String uname = "root";
			String pswd = "Oxford@505";
			Connection con = DriverManager.getConnection(url,uname,pswd);
			System.out.println("connected..");
			
			Statement stmt = con.createStatement();
			System.out.println("crteted ..");
			
			String insertQuery = "insert into employee_payroll(ID,NAME,CITY,SALARY,STARTDATE)"
					+ " values(5,'Avinash','Pune',2200,'2022-2-21'),(6,'Nitya','Thane',2100,'2022-1-10');";
			stmt.execute(insertQuery);
			System.out.println("insert done...");
			
			String selectQuery = "select salary from employee_payroll where name ='Avinash' ";
			stmt.execute(selectQuery);
			System.out.println("done select query");
			
			String selectQuery1 = "select* from employee";
			ResultSet rs = stmt.executeQuery(selectQuery1);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ rs.getString(2)+ rs.getString(3)+ rs.getInt(4)+rs.getString(5));
			System.out.println("done with data");
			}
			stmt.close();
			con.close();
			
			}catch(ClassNotFoundException e) {
			System.out.println(e);
			
			}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
