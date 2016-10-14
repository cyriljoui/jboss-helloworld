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

<h1>
<%

	String user = (String) request.getAttribute("user");
	out.print("Hello user JSP java: " + user);

%>
</h1>


	<h1>Hello ${user}!</h1>
	Congratulations! You succeeded deploying your first JSP application on wildfly!<br/>
	So what's next?


<c:out value="Hello JSTL ${user}"/>

<c:if test="${empty user}">
	User is not null...
</c:if>

<c:if test="${not empty user}">
	User is not null...
</c:if>

<a href="logout" >Logout</a>

</body>
</html>