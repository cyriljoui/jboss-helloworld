# JEE Tutorial on Wildfly

## JSP web application
In this step, we are going to integrate the JEE (7) CDI API to 
- manage authentication
- manage user _basket_ using CDI scopes (Session Scope) 

## Checkout application step
* run the following command to setup application step
```sh
	git checkout -f cdi
```
* deploy the application using
```sh
	mvn wildfly:deploy
```
* on your favorite browser, display [http://localhost:8080/jboss-helloworld/hello](http://localhost:8080/jboss-helloworld/hello)

You will prompt to enter a login/password to access the page.

### excercise
* Add a _remove item_ feature on the _/hello_ page
* Try removing the `implements Serializable` on the `UserSessionManager` and redeploy ... try to explain the error that appears on deployment

## Notes
Note the usage of

* Java / CDI
```java
	@Inject
	@SessionScoped
```

* in jsp pages
```html
	<c:forEach items="${basket.items}" var="entry">	
```
