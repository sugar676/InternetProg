package system;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Registration {
	
	// Method will connect to database and create tables
	public void connectToDatabase(){
		
		// variables created and initialised ready for connecting to the database
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "mydb";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "cosmic323";
		
		Connection conn = null;
		Statement stmt = null;
		//following try statement connects to database
		try{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			System.out.println("connecting to database");
			conn = DriverManager.getConnection(url, username, password);
		    System.out.println("Successfully connected to the database");
		    
		    System.out.println("Creating table within database");
		    
		    stmt = conn .createStatement();
		    
		    // SQL statements for creating the tables and columns of the database
		    String sql = "CREATE TABLE USER" +
		                 "(userid Integer not NULL," +
		    		     "first_Name VARCHAR(45)" +
		                 "second_Name VARCHAR(45)" +
		    		     "username VARCHAR (45)"+
		                 "password VARCHAR (45)" +
		    		     "email_address VARCHAR (75)"+
		                 "PRIMARY KEY (userid))";
		    
		    String sql2 = "CREATE TABLE TWEET" +
		                  "(tweetid Integer not NULL," +
		    		      "tweet VARCHAR (250)," +
		                  "username VARCHAR (45)" +
		    		      "PRIMARY KEY (tweetid))";
		    
		    String sql3 = "CREATE TABLE FRIENDS" +
		                  "(friendid Integer not NULL," +
		    		      "first_Name VARCHAR (45)," +
		                  "second_Name VARCHAR (45)," +
		    		      "username VARCHAR (45)," +
		                  "PRIMARY KEY (friendid))";
		    
		    stmt.executeUpdate(sql);
		    stmt.executeUpdate(sql2);
		    stmt.executeUpdate(sql3);
		    
		    System.out.println("tables created in database");
		    
		} 
		
		// Catches Exception
		catch (SQLException se) {
			
			se.printStackTrace();
		}
		     
		
		catch (Exception e){
			
			e.printStackTrace();
			
		}
		
		// Close connection to the database
		
		finally {
			
			try{
				
				if(stmt !=null)
					conn.close();
			}
			
			catch (SQLException se){
				
				
				
			}
			
			try{
				
				if (conn != null)
					conn.close();
				
			}
			
			catch (SQLException se){
				
				se.printStackTrace();
				
			
		}
		}
		
	
		}
		
		
		
		
	
	
	

	
	          
		

	

	
	
	
	public void registerDetails(String msg, String msg1, String msg2, String msg3, String msg4){
		
		 {
			 
			 connectToDatabase();
			 
			 // Create variables and initialise them ready for use connecting to Database
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "mydb";
				String driver = "com.mysql.jdbc.Driver";
				String username = "root";
				String password = "cosmic323";
				
				Connection conn = null;
				Statement stmt = null;
			 
			 //Connect To Database
	          Class.forName(driver).newInstance();
	          conn = DriverManager.getConnection(url, username, password);
	          Statement st = conn.createStatement();
	          ResultSet res = st.executeQuery("SELECT * FROM  mydb");
	          
	          while (res.next()) {
	              int id = res.getInt("id");
	               msg = res.getString("firstName");
	               msg1 = res.getString("secondName");
	               msg2 = res.getString("username");
	               msg3 = res.getString("password");
	               msg4 = res.getString("emailAddress");
	             
	              }

	    // Add data to database
	          String add = res.executeUpdate("INSERT into USER VALUES("+msg+","+msg1+","+msg2+","+msg3+","+msg4,"");
	          if(val==1)
	              System.out.print("Successfully inserted value");
	          conn.close();
	          } catch (Exception e) {
	          e.printStackTrace();
	          }
	         
	
	
		
	}

}
