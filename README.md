# JEE Tutorial on Wildfly

# JSP web application
In this step, we are going to set up a basic JSP Web application that displays your name.

## Wildfly AS
* download & install the wildfly AS (8+)
* start the wildfly server using the command 
```sh
	bin\standalone.bat
```

## Checkout application
Download the tutorial application using (git)
```sh
	git clone https://github.com/mahieddine-ichir/jboss-helloworld.git
```

### install application
* run the following command to set up application step
```sh
	git checkout -f jsp
``` 
* deploy the application on Wildfly AS using
```sh
mvn wildfly:deploy
```
* on your favorite browser, display [http://localhost:8080/jboss-helloworld/hello](http://localhost:8080/jboss-helloworld/hello)

### excercise 
modify the application to display your name instead.

## Notes usage of

```java
	request.setAttribute("user", "John Doe");
	request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
```
