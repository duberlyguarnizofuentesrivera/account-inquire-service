[![Quality gate](https://duberlyguarnizo.com/sonarqube/api/project_badges/quality_gate?project=Bootcamp-Account-Inquire-Service&token=sqb_fb30b73e25c1d90bcdd261a9752d81aa40ee8538)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Account-Inquire-Service)

# Account Inquire

## NttData Bootcamp Microservice

[![Coverage](https://duberlyguarnizo.com/sonarqube/api/project_badges/measure?project=Bootcamp-Account-Inquire-Service&metric=coverage&token=sqb_fb30b73e25c1d90bcdd261a9752d81aa40ee8538)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Account-Inquire-Service)
[![Bugs](https://duberlyguarnizo.com/sonarqube/api/project_badges/measure?project=Bootcamp-Account-Inquire-Service&metric=bugs&token=sqb_fb30b73e25c1d90bcdd261a9752d81aa40ee8538)](https://duberlyguarnizo.com/sonarqube/dashboard?id=Bootcamp-Account-Inquire-Service)

This service creates and retrieves transaction information for New Lima Bank.

Stack:

- Spring Boot 2.7
- Java 11
- MongoDb for persistence
- OpenApi Generator, for API design
- Remote configuration (Spring Cloud Config with GitHub)
- Integrated Eureka client
- SonarQube for coverage with SpotBugs (FindBugs) & CheckStyle
- Various DTO

Current endpoints are:

- **POST /transactions**: Creates a transaction given origin/destination accounts and other data.
- **GET /transactions/balance/{accountUUID}**: Returns the list of transactions for the given account.
- **GET /transactions/history/{accountUUID}**: Returns a *balance*, that is made of the number of operations and the
  average amount.

### Design

The service uses DDD and Hexagonal architectures. The code is organized so that model package does not depend on
anything. I have used functional programing, streams, lambdas, etc.

### Compile and Deploy

To deploy, simply compile the project and run the generated jar. This service requires:

- That the config server ir running in the same host, with port 8888.
- That there is a Eureka server (Spring Cloud Netflix) running at the same host, port 8761.

### Copyright

All code has been written by me, Duberly Guarnizo <duberlygfr@gmail.com> and the use by external personal of NttData is
explicitly forbidden.
