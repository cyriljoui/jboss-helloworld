# JEE Tutorial on Wildfly

## JSF web application
In this step, we are going to the same application using JSF technology highlighting the following features :
- authentication
- user _basket_ using JSF scopes (Session Scope)
- _faces-config.xml_ to manage flow navigation between pages 

## Checkout application step
* run the following command to setup application step
```sh
	git checkout -f jsf
```
* deploy the application using
```sh
	mvn wildfly:deploy
```
All JSF pages (through JSF Servlet, see web.xml) are mapped on _/faces/*_ route.

* on your favorite browser, display [http://localhost:8080/jboss-helloworld/](http://localhost:8080/jboss-helloworld/)

You will prompt to enter a login/password to access the _hello_ page.

### excercise
* Add a _remove item_ feature on the _/hello_ page
* Add a new view (.xhtml) page with a navigation rule on the _faces-config.xml_

## Notes
Note the usage of

* Java / JSF
```java
	@ManagedBean
	@ManagedProperty	
	@javax.faces.bean.SessionScoped
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
```

* in xhtml pages
```html
	<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
      
    <h:commandButton />
    <h:inputText />
    <h:outputText />	
```
explore xhtml pages ...