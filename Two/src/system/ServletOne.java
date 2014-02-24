package system;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import java.util.List;  
import javax.servlet.http.HttpServlet;
import java.sql.*;




// Servlet Method
public class ServletOne extends HttpServlet {
	
	Registration connect = new Registration();
	PrintWriter out = null;
			public void init(ServletConfig conf) throws
			ServletException{   
		
		super.init(conf);
	}
	
			// Do get to post Tweet
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
synchronized(this) {
			
			String Parameter=req.getParameter("Name");
			if (Parameter !=null){
				
				res.setContentType("text/html");
				try{
					
					out = new PrintWriter(res.getOutputStream());
				}catch(IOException E){}
				
				// Connect to Database
				connect.connectToDatabase();
				
				
				//Add Tweet To Database
				String add = "INSERT INTO TWEET" +
				             "VALUES Parameter";
				
				//Post Tweet
			     out.println("Tweet"+Parameter+"<p>");
			     RequestDispatcher dispatch = req.getRequestDispatcher("Interface.jsp"); 
			     dispatch.forward(req, res); 
			     
			     try{
					
					out.close();
					
				}
				catch(Exception E){
					
				}
				
				notify();
				
			}
		
	}
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		
	}
}
