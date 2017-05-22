<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="<c:url value="css/bootstrap.css" />" />
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>

<c:if test="${not empty pageContext.request.getUserPrincipal()}">
	<ul class="nav nav-tabs">
		<li role="presentataion"><a href="<c:url value="/"/>" >Home</a></li>
		<li role="presentataion"><a href="<c:url value="/secured/hello"/>" >${pageContext.request.getUserPrincipal().getName()}</a></li>
		<li role="presentation"><a href="<c:url value="/logout"/>">Logout</a></li>
	</ul>
</c:if>
<c:if test="${empty pageContext.request.getUserPrincipal()}">
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="<c:url value="/secured/hello" />">Connect</a></li>
	</ul>
</c:if>

<div class="container">

	<h2>Hello ${pageContext.request.getUserPrincipal().getName()}!</h2>
	Congratulations! You succeeded deploying your Web application on wildfly!
	<br/>
	Navigate on the above home page to test login/logout features.

</div>
</body>
</html>