<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="myServlet" method="POST">
		
		<p>Enter user name: <input type="text" name="username"/></p>
		<p>Enter password:	<input type="password" name="password"/>
		<input type="submit" name="login" value="login"/>
	</form>
</body>
</html>