# springbootjpa2
Sample Spring Boot with JPA 2 API and Junit 5

<https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html>

## Running the application
Simply clone or download the project. The main starting point for the application is  <https://github.com/morrisoncm/springbootjpa2/blob/master/src/main/java/com/demo/jpa2/Application.java>.

## Postman Scripts
To test using Postman the scripts are in the following location <https://github.com/morrisoncm/springbootjpa2/blob/master/postman/demo%20-%20students%20and%20subjects.postman_collection.json>

## Database - h2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the databse, tables, data and datasource and the data.sql and schema.dql.

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console with the following credentials are in the following directory . 
<https://github.com/morrisoncm/springbootjpa2/blob/master/src/main/resources/application.properties>
