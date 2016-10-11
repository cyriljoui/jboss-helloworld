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

* Java / JSF & CDI
```java
	@Named
	@ManagedBean		=> prefer usage of CDI @Named
	@ManagedProperty	=> prefer usage of CDI @Inject, @PostContruct
	@javax.faces.bean.SessionScoped	=> prefer useage of CDI scopes
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
```

* _faces-config.xml_ (navigation rules)
```xml
	<navigation-rule>
		<from-view-id>/login.xhtml</from-view-id>
		<navigation-case>
			<from-outcome>next</from-outcome>
			<to-view-id>/secured/hello.xhtml</to-view-id>
		</navigation-case>
	</navigation-rule>
	<navigation-rule>
		<from-view-id>/secured/hello.xhtml</from-view-id>
		<navigation-case>
			<from-action>#{hello.logout()}</from-action>
			<to-view-id>/index.xhtml</to-view-id>
		</navigation-case>
	</navigation-rule>
	
```

* in _web.xml_
```xml
	<servlet-mapping>
		<servlet-name>Faces Servlet</servlet-name>
		<url-pattern>/faces/*</url-pattern>
	</servlet-mapping>
	<servlet>
		<servlet-name>Faces Servlet</servlet-name>
		<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
```

* in xhtml pages
```html
	<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">
            
    <h:form />
    <h:commandButton />
    <h:inputText /> & <h:inputSecret /> 
    <h:outputText />
    <h:link />
```
and explore xhtml pages.