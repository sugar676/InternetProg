import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;




public class ServletOne extends HttpServlet {
	
	PrintWriter out = null;
			public void init(ServletConfig conf) throws
			ServletException{   
		
		super.init(conf);
	}
	
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
			     out.println("Tweet"+Parameter+"<p>");
				
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
