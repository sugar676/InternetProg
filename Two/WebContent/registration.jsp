<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="Registration*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<link rel="stylesheet" type="text/css" href="visual.css">
</head>
<body>
<p> Please fill in your details to register with the Twitter Clone</p>

<form name="login">
First Name<br><input type="text" name="firstNameid"/> <br>
                                           <br>
Last Name<br><input type="text" name="LastNameid"/> <br>
                                           <br>
Email Address<br><input type="text" name="EmailAddressid"/> <br>
                                           <br>
Username<br><input type ="text" name="Usernameid"/> <br>
                                           <br>
Password<br><input type="text" name="Passwordid"/> <br>
                                           <br>
                                           


<input type="button" onclick="check(this.form)" value="Register"/>
<br>
< p/>
</form>

<jsp:useBean id="link" scope="application" class = "Registration" />   
  <% Registration r=new Registration();
  r.registerDetails("firstNameid, LastNameid, EmailAddressid, UserNameid, Passwordid");
 %>


</body>
</html>