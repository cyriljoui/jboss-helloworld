# JEE Tutorial on Wildfly

## JSP web application
In this step, we are going to integrate the JEE (7) CDI API to 
- manage authentication
- manage user _basket_ using CDI scopes (Session Scope) 
- create a _CDI Factory_ for injecting loggers

## Checkout application step
* run the following command to setup application step
```sh
	git checkout -f cdi
```
* deploy the application using
```sh
	mvn wildfly:deploy
```
* on your favorite browser, display [http://localhost:8080/jboss-helloworld/](http://localhost:8080/jboss-helloworld/)

You will prompt to enter a login/password to access the page.

### excercise
* Add a _remove item_ feature on the _/secured/hello_ page
* Try removing the `implements Serializable` on the `UserSessionManager` and redeploy ... try to explain the error that appears on deployment
* If the user disconnects and reconnects, the Items are lost, try to propose a solution using CDI so that added Items are not lost on logout (Hint: use one of the CDI scopes for in memory persistence)

## Notes
Note the usage of

* Java / CDI
```java
	@Inject				-> DI
	@Produces			-> counter part of @Inject
	@SessionScoped		-> scope context
	@ApplicationScoped	-> scope context
```
and notice how we changed
```java
	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
```
to
```java
	@Inject
	private Logger logger;
```

* in _web.xml_
```xml
	<session-config>
		<tracking-mode>COOKIE</tracking-mode>
	</session-config>
```

* in jsp pages
```html
	<c:forEach items="${basket.items}" var="entry">	
```
