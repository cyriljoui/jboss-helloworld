<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Please login</h1>
	<form method="post" action="login">
		Username: <input type="text" name="username" /> <br/>
		Password: <input type="password" name="password" /> <br/>
		
		<input type="submit" value="login" />
	</form>
	<hr/>
	<ol>
		<li>username: john.doe, password: pwd</li>
		<li>username: ?add you username?, password: pwd</li>
	</ol>
</body>
</html>