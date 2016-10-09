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
	<h2>Hello ${user}!</h2>
	Use the following form to add your favorite items to your basket.
	<br/>
	<i>example: Audi A3 TFSI black edition</i>
	<br/>
	<form method="post" action="baskets">
		<div class="form-group">
			<input type="text" name="item" placeholder="Item description" class="form-control" />
		</form-group>
		<input type="submit" value="Add Item" class="btn btn-default" />
	</form>

	<hr/>
	<table class="table table-bordered">
	<tr>
		<th>description</th>
		<th>reference</th>
	</tr>
	<c:forEach items="${basket.items}" var="entry">
	<tr>
		<td>${entry.value}</td>
		<td>${entry.key}</td>
	</tr>		
	</c:forEach>
	</table>
</div>

</body>
</html>