# E-Commerce Application - Spring Boot Backend + Docker

This project was created to develop the backend of an e-commerce platform using Java Spring Boot. The application includes basic features such as user management, product management, and authorization, and uses a MySQL database. Docker integration is also provided so that the application can be easily deployed and run using Docker.

    Project Structure:

    -config: Application configuration files and settings.
    -dto: Data Transfer Objects (DTO) and request/response objects.
    -model: Entity classes representing database tables.
    -repository: JPA repository interfaces used for database operations.
    -service: Business logic and service layer.
    -controller: RESTful controllers defining API endpoints.

    Technologies Used:

    -Java 17: Main programming language.
    -Spring Boot 3.3.1: Framework for fast and easy development.
    -Spring Data JPA: JPA-based solution for database operations.
    -MySQL: Database solution.
    -Docker: For application containerization and deployment.
    -Gradle: Project management and dependency management.


## Dependencies

This project uses the following dependencies:
- **Spring Boot Starter Data JPA**: For database interactions (`org.springframework.boot:spring-boot-starter-data-jpa`)
- **Spring Boot Starter Web**: For building web applications (`org.springframework.boot:spring-boot-starter-web`)
- **Spring Boot Starter Security**: For securing the application (`org.springframework.boot:spring-boot-starter-security`)
- **Gson**: For JSON serialization/deserialization (`com.google.code.gson:gson:2.11.0`)
- **Lombok**: For reducing boilerplate code (`org.projectlombok:lombok`)
- **MySQL Connector**: For MySQL database connectivity (`mysql:mysql-connector-java:8.0.28`)
- **JUnit**: For testing (`org.springframework.boot:spring-boot-starter-test`, `org.junit.platform:junit-platform-launcher`)
- **Spring Boot Actuator**: For monitoring and managing the application (`org.springframework.boot:spring-boot-starter-actuator`)
- **Spring Boot DevTools**: For development enhancements (`org.springframework.boot:spring-boot-devtools`)
- **Spring Security Test**: For testing security (`org.springframework.security:spring-security-test`)
- **MapStruct**: For object mapping (`org.mapstruct:mapstruct:1.5.5.Final`)
- **Springdoc OpenAPI**: For API documentation (`org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0`)
- **Java JWT (JJWT)**: For JWT creation and validation (`io.jsonwebtoken:jjwt-api:0.11.5`, `io.jsonwebtoken:jjwt-impl:0.11.5`, `io.jsonwebtoken:jjwt-jackson:0.11.5`)
- **Apache Commons Lang**: For utility classes (`org.apache.commons:commons-lang3:3.12.0`)

## Database Configuration

To configure the database, the following properties should be set in your `application.properties` file:
    spring.datasource.url=jdbc:mysql://localhost:3306/DatabaseName?useSSL=false&serverTimezone=UTC
    spring.datasource.username=YourDatabaseUserName
    spring.datasource.password=YourDatabaseUserPassword
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto = update
    spring.jpa.properties.hibernate.format_sql = true
    
Properties:
    -User Management: User registration, login, authorization and authorization with roles (SuperUser, NormalUser).
    -Product Management: Add, update, delete and list products.
    -Authorization: Secure API access using JWT.