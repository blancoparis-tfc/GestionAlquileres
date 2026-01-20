# Guías de Agente para GestionAlquileres

Este documento proporciona pautas para agentes de IA que trabajan en la aplicación Spring Boot GestionAlquileres. Contiene comandos de compilación, procedimientos de prueba y directrices de estilo de código para garantizar consistencia y calidad.

## Visión General del Proyecto
- **Pila Tecnológica**: Spring Boot 4.0.1, Java 25, Maven, JPA/Hibernate, Base de Datos H2
- **Estructura del Paquete**: `com.dbp.gestionAlquiler`
- **Arquitectura**: API REST con entidades JPA y configuración automática de Spring Boot

## Comandos de Compilación y Desarrollo

### Comandos de Compilación
```bash
# Compilar la aplicación
mvn clean compile

# Empaquetar la aplicación en un JAR
mvn clean package

# Ejecutar la aplicación en modo de desarrollo
mvn spring-boot:run

# Generar build-info.properties (requerido para el bean BuildProperties)
mvn spring-boot:build-info
```

### Comandos de Prueba
```bash
# Ejecutar todas las pruebas
mvn test

# Ejecutar una clase de prueba específica
mvn test -Dtest=GestionAlquilerApplicationTests

# Ejecutar un método de prueba específico
mvn test -Dtest=GestionAlquilerApplicationTests#contextLoads

# Ejecutar pruebas con salida detallada
mvn test -DforkCount=1 -DreuseForks=false

# Ejecutar pruebas y generar reporte de cobertura (si se agrega el plugin jacoco)
mvn test jacoco:report

# Ejecutar prueba específica con información de depuración
mvn test -Dtest=StatusControllerTests -Ddebug=true
```

### Comandos de Calidad del Código
```bash
# Verificar errores de compilación
mvn compile

# Validar el proyecto (compilación, pruebas, etc.)
mvn validate

# Limpiar artefactos de compilación
mvn clean

# Ciclo completo de limpieza, compilación y prueba
mvn clean compile test

# Ejecutar objetivo específico de maven para verificar dependencias
mvn dependency:tree
```

## Directrices de Estilo de Código

### Estructura del Paquete
- **Paquete Base**: `com.dbp.gestionAlquiler`
- **Controladores**: `com.dbp.gestionAlquiler.controller`
- **Entidades/Modelos**: `com.dbp.gestionAlquiler.model`
- **Servicios**: `com.dbp.gestionAlquiler.service` (cuando se agreguen)
- **Repositorios**: `com.dbp.gestionAlquiler.repository` (cuando se agreguen)
- **Configuración**: `com.dbp.gestionAlquiler.config` (cuando se agreguen)

### Convenciones de Nomenclatura
- **Clases**: PascalCase (por ejemplo, `StatusController`, `SystemLog`)
- **Métodos**: camelCase (por ejemplo, `getStatus()`, `checkDatabaseConnection()`)
- **Variables**: camelCase (por ejemplo, `buildProperties`, `jdbcTemplate`)
- **Constantes**: UPPER_SNAKE_CASE (cuando se usen)
- **Paquetes**: minúsculas con puntos (por ejemplo, `com.dbp.gestionAlquiler.controller`)

### Estructura de Clases y Anotaciones

#### Controladores
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
        // Implementación
    }

    // Métodos auxiliares privados
    private boolean checkDatabaseConnection() {
        // Implementación
    }

    // Clases internas para DTOs de respuesta
    public static class StatusResponse {
        // Campos, constructor, getters/setters
    }
}
```

#### Entidades
```java
@Entity
@Table(name = "system_log")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Constructor por defecto
    public SystemLog() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor con parámetros
    public SystemLog(Long id) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... otros getters/setters
}
```

### Organización de Importaciones
- **Framework Spring**: Agrupar importaciones de Spring juntas
- **Biblioteca Estándar de Java**: Agrupar importaciones java/jakarta
- **Bibliotecas de Terceros**: Agrupar dependencias externas
- **Clases del Proyecto**: Agrupar importaciones internas

Ejemplo:
```java
// Importaciones de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importaciones de Jakarta/Java
import jakarta.persistence.*;
import java.time.LocalDateTime;

// Importaciones del proyecto
import com.dbp.gestionAlquiler.model.SystemLog;
```

### Inyección de Dependencias
- Usar `@Autowired` en campos (no en constructor en el código existente)
- Preferir inyección por campo para mantener consistencia con la base de código existente
- Inyectar servicios, repositorios y beans de configuración según sea necesario

### Manejo de Errores
- Usar bloques try-catch para operaciones de base de datos y llamadas externas
- Devolver códigos de estado HTTP apropiados mediante ResponseEntity
- Registrar errores adecuadamente (cuando se agregue un framework de registro)
- Validar parámetros de entrada

Ejemplo:
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

### Base de Datos y JPA
- Usar `@Entity` para entidades de base de datos
- Usar `@Table(name = "table_name")` para mapeo de tablas
- Usar `@Column(name = "column_name")` para mapeo de columnas
- Usar `@Id` y `@GeneratedValue` para claves primarias
- Usar `LocalDateTime` para campos de marca temporal
- Configurar H2 para desarrollo/pruebas

### Diseño de API REST
- Usar patrones de URL RESTful (por ejemplo, `/api/status`)
- Devolver ResponseEntity con códigos de estado apropiados
- Usar clases estáticas internas para DTOs de respuesta
- Seguir convenciones de nomenclatura JSON (camelCase)

### Formateo del Código
- Usar 4 espacios para sangría
- Colocar llaves de apertura en la misma línea
- Agregar líneas en blanco entre definiciones de métodos
- Agregar comentarios para lógica empresarial compleja
- Mantener longitudes de línea razonables (< 120 caracteres)

### Directrices de Pruebas
- Usar JUnit 5 (`@Test` anotación)
- Usar `@SpringBootTest` para pruebas de integración
- Probar puntos finales REST con TestRestTemplate (cuando se agreguen)
- Probar operaciones de base de datos con `@DataJpaTest` (cuando se agreguen)
- Seguir patrón de nombramiento: `ClassNameTests`
- Probar casos límite y condiciones de error
- Usar pruebas parametrizadas cuando sea apropiado

### Configuración
- Usar `application.properties` para configuración
- Configurar adecuadamente los ajustes de base de datos
- Habilitar consola H2 para desarrollo
- Establecer propiedades JPA para gestión de esquema

### Consideraciones de Seguridad
- Validar todos los parámetros de entrada
- Usar consultas parametrizadas para prevenir inyección SQL
- Evitar exponer información sensible en registros
- Seguir el principio del privilegio mínimo

### Mejores Prácticas de Rendimiento
- Usar agrupación de conexiones (HikariCP configurado automáticamente)
- Evitar problemas de consultas NX+1 en JPA
- Usar índices apropiados en columnas frecuentemente consultadas
- Almacenar datos estáticos en caché cuando sea apropiado

### Documentación
- Agregar comentarios JavaDoc para APIs públicas
- Documentar lógica empresarial compleja
- Mantener README.md actualizado con instrucciones de configuración
- Documentar propiedades de configuración

## Organización de Archivos
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

## Flujo de Desarrollo
1. **Configuración**: Clonar repositorio y ejecutar `mvn clean compile`
2. **Desarrollo**: Hacer cambios siguiendo las directrices de estilo
3. **Pruebas**: Ejecutar `mvn test` para asegurar que las pruebas pasen
4. **Construcción**: Ejecutar `mvn clean package` para construcción de producción
5. **Verificación**: Ejecutar `mvn spring-boot:run` para probar la aplicación

## Problemas Comunes y Soluciones
- **Falló la compilación**: Verificar errores de sintaxis, asegurarse de que las dependencias estén disponibles
- **Fallan las pruebas**: Verificar configuración de base de datos, comprobar conflictos de puertos
- **La aplicación no se inicia**: Verificar application.properties, verificar versión de Java
- **Problemas de conexión a la base de datos**: Asegurarse de que H2 esté configurado correctamente

## Información de Versión
- **Spring Boot**: 4.0.1
- **Java**: 25
- **Maven**: 3.9+
- **JUnit**: 5 (Jupiter)
- **Base de Datos H2**: Versión compatible más reciente

## Instrucciones de Cursor/Copilot
No se encontraron reglas específicas de Cursor o Copilot en este repositorio.

Este documento debe actualizarse a medida que el proyecto evolucione y se establezcan nuevos patrones.