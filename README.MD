# OpenFleet
Openfleet is a Java web application developed using the Spring framework to help in the management of micro and small
transportation businesses.

[![Build Status](https://travis-ci.org/Chrams/openfleet.svg?branch=master)](https://travis-ci.org/Chrams/openfleet)
[![codecov](https://codecov.io/gh/Chrams/openfleet/branch/master/graph/badge.svg)](https://codecov.io/gh/Chrams/openfleet)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/01f0f9c60c5545aaa95cce793547a3b0)](https://www.codacy.com/app/Chrams/openfleet?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Chrams/openfleet&amp;utm_campaign=Badge_Grade)

### Usage
Run using spring-boot:

```
mvn spring-boot:run
```

Create executable uberjar:

```
mvn package
```

Generate site documentations:

```
mvn site
```

The embedded LDAP server hase a single user. You can login using:
 * username: admin
 * password: password

### Configurations
All application configurations are currently stored in the 
[application.properties](https://github.com/Chrams/openfleet/blob/master/src/main/resources/application.properties) file.
#### LDAP Server configuration
To use other than the embedded LDAP server, you'll need to specifiy your LDAP server's url and base in the configuration file.
Example:
```
ldap.contextSource.url=ldap://localhost:389
ldap.contextSource.base=cn=Users,dc=test,dc=local
```
#### Database configuration
This application does not come with embedded relational database service. So you'll need to provide your own.
To do that you'll need to modify the configuration file accordingly:
```
spring.datasource.url = jdbc:protocol:the.url.of.your.dbserver/yourschema
spring.datasource.username = yourUsername
spring.datasource.password = yourPassword
spring.datasource.driverClassName = your.dbservers.jdbc.driver
```
### Disclaimer
Since this was a school project, no further development is planned yet.