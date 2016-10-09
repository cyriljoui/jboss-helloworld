<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="<c:url value="/"/>" />
<link rel="stylesheet" href="<c:url value="css/bootstrap.css" />" />
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty user}">
	<ul class="nav nav-tabs">
		<li role="presentataion"><a href="<c:url value="/"/>" >Home</a></li>
		<li role="presentataion"><a href="<c:url value="/secured/hello"/>" >${user}</a></li>
		<li role="presentation"><a href="<c:url value="/logout"/>">Logout</a></li>
	</ul>
</c:if>
<c:if test="${empty user}">
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="<c:url value="/secured/hello" />">Connect</a></li>
	</ul>
</c:if>

<div class="container">
	<h2>JSP Servlet with login feature</h2>
	The application aims to highlight some of the <a href="https://jstl.java.net/" target="_blank">jstl</a> tags along with authentication feature and user management in session.
	<br/><br/>
	Use the navigation bar above to connect to your home page, logout, to naviagte ...
</div>

</body>
</html>