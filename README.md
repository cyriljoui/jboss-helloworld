# JEE Tutorial on Wildfly

## JSP web application
In this step, we are going to add some _login_ feature to our application. We will thus highlight the usage of 
- _jstl_ tags
- JEE _WebFilers_ for authentication access handling 

## Checkout application step
* run the following command to setup application step
```sh
	git checkout -f jstl
```
* deploy the application using
```sh
	mvn wildfly:deploy
```
* on your favorite browser, display [http://localhost:8080/jboss-helloworld/hello](http://localhost:8080/jboss-helloworld/hello)

You will prompt to enter a login/password to access the page.

### excercise
* Add your username to authorized users
* Add _Invalid username / password_ 

## Notes
Note the usage of

* in _AuthenticationFilter_
```java
	req.getServletPath();
	req.getSession().setAttribute();
	chain.doFilter(request, response);
```
* in _LoginServlet_
```java
	request.getParameter();
	response.sendRedirect();
```
* in _LogoutServlet_
```java
	request.getSession().invalidate();	
```

* in jsp pages
```html
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:if test="${not empty user}">
	
```
