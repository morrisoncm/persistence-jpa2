# springbootjpa2
Sample Spring Boot with JPA 2 API and Junit 5

<https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html>

# Database - h2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the datasource and the data.sql and schema.dql with initialize a sample demo_users db with a default user. To access the database. 

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console with the following credentials

jbdc url = jdbc:h2:mem:studentdb
username = sa
password =


# Postman scripts
To test using Postman the scripts are in the following location postman/demo - users.postman_collection.json.  Simply clone or download the project. The main starting point for the application is the com.demo.jdbc.Application.java
