<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<c:url value="/"/>" />
<link rel="stylesheet" href="<c:url value="css/bootstrap.css" />" />
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>

</head>
<body>
<div class="container">
	<h3>Login</h3>
	<form class="form-horizontal" method="post" action="<c:url value="/login" />">
	<div class="form-group">
		<label class="col-sm-2">Username</label>
		<div class="col-sm-10"><input class="form-control" type="text" name="username" /></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2">Password</label>
		<div class="col-sm-10"><input class="form-control" type="password" name="password" /></div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input class="btn btn-default" type="submit" value="login" />
		</div>
	</div>
	</form>
	<hr/>
	<h3>Hints</h3>
	<i>Use one of the followings accounts to login.</i>
	<ol>
		<li>username: john.doe, password: pwd</li>
		<li>username: ?add you username?, password: pwd</li>
	</ol>
</div>
</body>
</html>