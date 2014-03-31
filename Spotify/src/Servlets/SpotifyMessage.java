package Servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.*;

import com.spotify.lib.*;
import com.spotify.models.*;
import com.spotify.stores.*;

/**
* Servlet implementation class Tweet
*/
@WebServlet(urlPatterns = { "/Tweet", "/Tweet/*" })
public class SpotifyMessage extends HttpServlet {
private static final long serialVersionUID = 1L;
    private Cluster cluster;
    private Session session;
    /**
* @see HttpServlet#HttpServlet()
*/
    public SpotifyMessage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config, int id, String message) throws ServletException {
// TODO Auto-generated method stub
cluster = CassandraHosts.getCluster();

   
	session.execute("INSERT INTO messages("+ id +","+ message +");");
	

}
    
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//String args[]=Convertors.SplitRequestPath(request);
Message tm= new Message();
tm.setCluster(cluster);
LinkedList<PostMessage> tweetList = tm.getTweets();
request.setAttribute("Tweets", tweetList); //Set a bean with the list in it
RequestDispatcher rd = request.getRequestDispatcher("/RenderTweets.jsp");

rd.forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}