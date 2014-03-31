<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page import="com.spotify.stores.*" %>
    <%@ page import="com.spotify.lib.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Message</title>
</head>
<body>

<h1>Message</h1>

<centre>
<form action="RenderMessage.jsp" method="post">
<br/>Message:<input type="text" name="message">

<br/><input type="submit" value="Submit">
</form>
</centre>

<%
        String message=request.getParameter("message");
        session.setAttribute("message", message);
        
        
        String a=session.getAttribute(message).toString(); 
        
        
        
        
       
        %>




<%
System.out.println("In render");




List<PostMessage> lTweet = (List<PostMessage>)request.getAttribute("message");

if (lTweet==null){
 %>
<p>No Message found</p>
<%
}else{
%>


<%
Iterator<PostMessage> iterator;


iterator = lTweet.iterator();
while (iterator.hasNext()){
PostMessage ts = (PostMessage)iterator.next();

%>
<%=ts.getUser() %>" ><%=ts.getTweet() %><<br/><%

}
}
%>

</body>
</html>