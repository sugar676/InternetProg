<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<link rel="stylesheet" type="text/css" href="visual.css">
</head>
<body>

<p>

Welcome to the Twitter Clone
</p>
<p>

If you don't have an account you can register  <a href="registration.jsp">here</a>
</p>

<p>

For existing users enter your username and password below

</p>

/*tes */

<form name="login">
<form action="urlServletOne" method="post">
Username<input type="text" name="userid"/> <br>
                                           <br>
Password<input type="password" name="pswrd"/>
<input type="button" onclick="check(this.form)" value="Login"/>
<br>
<input type="reset" value="Cancel"/>
</form>

<script language="javascript">
function check(form)/*function to check userid & password*/
{
/*the following code checkes whether the entered userid and password are matching*/
if(form.userid.value == "myuserid" && form.pswrd.value == "mypswrd")
{
window.open('target.html')/*opens the target page while Id & password matches*/
}
else
{
alert("Error Wrong Username or Password")/*displays error message*/
}


}
</script>
<jsp:useBean id="link" scope="application" class = "CheckDetails" />
<% CheckDetails a=new CheckDetails();
  a.check("userid, pswrd");
 %>

</body>
</html>