# Agent Guidelines for GestionAlquileres

This document provides guidelines for AI agents working on the GestionAlquileres Spring Boot application. It contains build commands, testing procedures, and code style guidelines to ensure consistency and quality.

## Project Overview
- **Technology Stack**: Spring Boot 4.0.1, Java 25, Maven, JPA/Hibernate, H2 Database
- **Package Structure**: `com.dbp.gestionAlquiler`
- **Architecture**: REST API with JPA entities and Spring Boot auto-configuration

## Build and Development Commands

### Build Commands
```bash
# Compile the application
mvn clean compile

# Package the application into a JAR
mvn clean package

# Run the application in development mode
mvn spring-boot:run

# Generate build-info.properties (required for BuildProperties bean)
mvn spring-boot:build-info
```

### Test Commands
```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=GestionAlquilerApplicationTests

# Run a specific test method
mvn test -Dtest=GestionAlquilerApplicationTests#contextLoads

# Run tests with verbose output
mvn test -DforkCount=1 -DreuseForks=false

# Run tests and generate coverage report (if jacoco plugin is added)
mvn test jacoco:report

# Run specific test with debug information
mvn test -Dtest=StatusControllerTests -Ddebug=true
```

### Code Quality Commands
```bash
# Check for compilation errors
mvn compile

# Validate the project (compilation, tests, etc.)
mvn validate

# Clean build artifacts
mvn clean

# Full clean build and test cycle
mvn clean compile test

# Run specific maven goal to check dependencies
mvn dependency:tree
```

## Code Style Guidelines

### Package Structure
- **Base Package**: `com.dbp.gestionAlquiler`
- **Controllers**: `com.dbp.gestionAlquiler.controller`
- **Entities/Models**: `com.dbp.gestionAlquiler.model`
- **Services**: `com.dbp.gestionAlquiler.service` (when added)
- **Repositories**: `com.dbp.gestionAlquiler.repository` (when added)
- **Configuration**: `com.dbp.gestionAlquiler.config` (when added)

### Naming Conventions
- **Classes**: PascalCase (e.g., `StatusController`, `SystemLog`)
- **Methods**: camelCase (e.g., `getStatus()`, `checkDatabaseConnection()`)
- **Variables**: camelCase (e.g., `buildProperties`, `jdbcTemplate`)
- **Constants**: UPPER_SNAKE_CASE (when used)
- **Packages**: lowercase with dots (e.g., `com.dbp.gestionAlquiler.controller`)

### Class Structure and Annotations

#### Controllers
```java
@RestController
@RequestMapping("/api")
public class StatusController {

    @Autowired
    private BuildProperties buildProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        // Implementation
    }

    // Private helper methods
    private boolean checkDatabaseConnection() {
        // Implementation
    }

    // Inner classes for response DTOs
    public static class StatusResponse {
        // Fields, constructor, getters/setters
    }
}
```

#### Entities
```java
@Entity
@Table(name = "system_log")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Default constructor
    public SystemLog() {
        this.timestamp = LocalDateTime.now();
    }

    // Parameterized constructor
    public SystemLog(Long id) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... other getters/setters
}
```

### Import Organization
- **Spring Framework**: Group Spring imports together
- **Java Standard Library**: Group java/jakarta imports
- **Third-party Libraries**: Group external dependencies
- **Project Classes**: Group internal imports

Example:
```java
// Spring imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Jakarta/Java imports
import jakarta.persistence.*;
import java.time.LocalDateTime;

// Project imports
import com.dbp.gestionAlquiler.model.SystemLog;
```

### Dependency Injection
- Use `@Autowired` on fields (not constructor injection in existing code)
- Prefer field injection for consistency with existing codebase
- Inject services, repositories, and configuration beans as needed

### Error Handling
- Use try-catch blocks for database operations and external calls
- Return appropriate HTTP status codes via ResponseEntity
- Log errors appropriately (when logging framework is added)
- Validate input parameters

Example:
```java
private boolean checkDatabaseConnection() {
    try {
        jdbcTemplate.execute("SELECT 1");
        return true;
    } catch (Exception e) {
        return false;
    }
}
```

### Database and JPA
- Use `@Entity` for database entities
- Use `@Table(name = "table_name")` for table mapping
- Use `@Column(name = "column_name")` for column mapping
- Use `@Id` and `@GeneratedValue` for primary keys
- Use `LocalDateTime` for timestamp fields
- Configure H2 for development/testing

### REST API Design
- Use RESTful URL patterns (e.g., `/api/status`)
- Return ResponseEntity with appropriate status codes
- Use inner static classes for response DTOs
- Follow JSON naming conventions (camelCase)

### Code Formatting
- Use 4 spaces for indentation
- Place opening braces on the same line
- Add blank lines between method definitions
- Add comments for complex business logic
- Keep line lengths reasonable (< 120 characters)

### Testing Guidelines
- Use JUnit 5 (`@Test` annotation)
- Use `@SpringBootTest` for integration tests
- Test REST endpoints with TestRestTemplate (when added)
- Test database operations with `@DataJpaTest` (when added)
- Follow naming pattern: `ClassNameTests`
- Test edge cases and error conditions
- Use parameterized tests where appropriate

### Configuration
- Use `application.properties` for configuration
- Configure database settings appropriately
- Enable H2 console for development
- Set JPA properties for schema management

### Security Considerations
- Validate all input parameters
- Use parameterized queries to prevent SQL injection
- Avoid exposing sensitive information in logs
- Follow principle of least privilege

### Performance Best Practices
- Use connection pooling (HikariCP configured automatically)
- Avoid NX+1 query problems in JPA
- Use appropriate indexes on frequently queried columns
- Cache static data when appropriate

### Documentation
- Add JavaDoc comments for public APIs
- Document complex business logic
- Keep README.md updated with setup instructions
- Document configuration properties

## File Organization
```
src/
├── main/
│   ├── java/com/dbp/gestionAlquiler/
│   │   ├── GestionAlquilerApplication.java
│   │   ├── controller/
│   │   │   └── StatusController.java
│   │   └── model/
│   │       └── SystemLog.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/dbp/gestionAlquiler/
        └── GestionAlquilerApplicationTests.java
```

## Development Workflow
1. **Setup**: Clone repository and run `mvn clean compile`
2. **Development**: Make changes following style guidelines
3. **Testing**: Run `mvn test` to ensure tests pass
4. **Build**: Run `mvn clean package` for production build
5. **Verification**: Run `mvn spring-boot:run` to test application

## Common Issues and Solutions
- **Build fails**: Check for syntax errors, ensure dependencies are available
- **Tests fail**: Verify database configuration, check for port conflicts
- **Application won't start**: Check application.properties, verify Java version
- **Database connection issues**: Ensure H2 is properly configured

## Version Information
- **Spring Boot**: 4.0.1
- **Java**: 25
- **Maven**: 3.9+
- **JUnit**: 5 (Jupiter)
- **H2 Database**: Latest compatible version

## Cursor/Copilot Instructions
No specific Cursor or Copilot rules found in this repository.

This document should be updated as the project evolves and new patterns are established.