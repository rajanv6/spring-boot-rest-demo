# Spring Boot Demo Application

#### Prerequisites
* Java 1.8
* Maven 3.6.3
* Spring Boot 2.2.6

#### Build
###### To build the project
```
mvn clean install
```
###### To run the test cases
```
mvn test
```

#### Summary
```
1.This application demonstrates how to create a REST service using Spring Boot.
2.The following REST endpoints have been implemented listening on port 9091.
a.POST /api/add (adding two numbers)
b.POST /api/diff (finding difference of two numbers)
JSON input format
{
    "x":"100",
    "y":"50"
}
3.The services haven been secured using spring basic authentication.
default username : user    password: pass
4.Integration test cases are written to test the REST Api's.

```