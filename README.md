# JEE Tutorial on Wildfly

## Wildfly administration
In this step, we are going to configure wildfly in domain mode :

### Domain Master configuration

1. execute `add-user.sh(.bat)` to add a new user (say "slave") that will connect to dmain master from domain slave (choose 'Management User' and answer yes to 'Is this new user going to be used for one AS process ... ?')

_save the output displayed by the server
```xml
	<secret value="cx2hdmU=" />
```
as it is needed to configure slave connection to master_.

### Domain Slave configuration
 
1. Set the name of the host to 'slave' (each slave in the domain must have a different name)
```xml
	<host xmlns="..." name="slave">
		...
	</host>
```
2. Add a new _security realm_
```xml
	<security-realm name="SlaveRealm">
		<server-identities>
			<secret value="report here add-user secret output" />
		</server-identities>
	</security-realm>
```
3. find and replace `domain-controller` xml tag `<local />` config with the following
```xml
	<domain-controller>
		<remote host="master IP address" port="9999" username="user added above" security-realm="SlaveRealm" />
	</domain-controller>
```

### Starting all together

1. Start the domain master using the following command:
```sh
bin/domain.sh -b 0.0.0.0 -bmanagement <master IP address>
```
2. Start the domain slave using the following command:
```sh
bin/domain.sh
```
On launch, you should observe on both servers (master and slave) that connection has been established (slave joined master).

## Testing the domain mode

1. Launch the JBoss command line interface using the following command
```sh
bin/jboss-cli.sh --connect --controller=<master IP address>:9999 
```
2. Try deploy an application through the _jboss-cli_ and observers what happens on both servers.
 



