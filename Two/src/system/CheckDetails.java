package system;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 



import java.util.List;  

import javax.servlet.http.HttpServlet;

import java.sql.*;


public class CheckDetails extends HttpServlet {
	
	Registration connect = new Registration();
	
	public void check(String username, String password){
		//Connect To Database.
        Connection conn = null;
		connect.connectToDatabase();
		Statement st = conn.createStatement();
		ResultSet res = st.executeQuery("SELECT USER FROM  mydb");
		
		
	}
	
	//Return Username
	public String getUsername(String username){
		
		return username;
	}
	
	//Return Password
	
	public String getPassword(String password){
		
		return password;
	}

}
