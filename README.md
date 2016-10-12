# JEE Tutorial on Wildfly

## JPA based application
In this step, we are going to integration to the JSF web application backend data persistence using JPA to store :
- user authentication credentials (username and password)
- user added items (on user home page)

## Checkout application step
* run the following command to setup application step
```sh
	git checkout -f jpa
```
* deploy the application using
```sh
	mvn wildfly:deploy
```
* on your favorite browser, display [http://localhost:8080/jboss-helloworld/](http://localhost:8080/jboss-helloworld/)

### excercise
* Add a _remove item_ feature on the _/hello_ page that removes data user persisted items
* Remove _@Transactional_ annotation from `getItems()` method, redeploy and explain the errors you have
* Review and look for differences in `Basket` class `addItem` and explore differences of usage (UserDAO addItem proposes two implementations of adding Item to items list) 

## Notes
Note the usage of

* Java / JSF, JPA, EJB & CDI
```java
	@Stateless				=> EJB
	@Transactional			=> CDI
	@PersistenceContext		=> JPA
	@Entity					=> JPA
	@OneToMany				=> JPA
	@JoinColumn				=> JPA
	@EntityListeners		=> JPA
```

* _persistence.xml- (JPA)
```xml
	<persistence-unit name="helloPU" transaction-type="JTA">
		<jta-data-source>java:jboss/datasources/HelloDS</jta-data-source>
			<properties>
				<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
				<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/data.sql" />
			...
```

* You have on the root of the project, the wildfly configuration files (standalone.xml) for the different versions of Wildfly. These files contain data source configurations needed for this lab.

_explorer commented lines (at node subsystem/datasources) on these configuration files_
