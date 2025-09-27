package com.util;

import java.sql.Connection;
import java.sql.DriverManager;



//Group Members 

//Fidele MUSABIKA 223003195
//UMURERWA Aline Carine 223010696
//TUYIKUNDE Rebecca 223010994


public class DB {
	public static Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql: //localhost:3306/insurance","root","");		
		
	}
}
