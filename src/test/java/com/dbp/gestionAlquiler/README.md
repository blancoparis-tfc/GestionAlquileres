# Clases Abstractas de Prueba

Este directorio contiene clases abstractas que facilitan la creación de pruebas en la aplicación GestionAlquileres.

## Clases Disponibles

### BaseTest
- **Propósito**: Clase base abstracta que proporciona configuración básica para todas las pruebas
- **Funcionalidad**: Incluye configuraciones comunes y métodos auxiliares que pueden ser utilizados por todas las clases de prueba

### SpringBootBaseTest
- **Propósito**: Clase base que extiende BaseTest y proporciona configuración específica de Spring Boot
- **Funcionalidad**: 
  - Incluye anotaciones @SpringBootTest necesarias
  - Configura el contexto de Spring para pruebas integrales
  - Proporciona acceso a beans de Spring

### MockMvcBaseTest
- **Propósito**: Clase base para pruebas que utilizan MockMvc
- **Funcionalidad**:
  - Configura MockMvc para pruebas de controladores REST
  - Proporciona métodos auxiliares para hacer solicitudes HTTP simuladas
  - Facilita la verificación de respuestas HTTP

### IntegrationBaseTest
- **Propósito**: Clase base para pruebas de integración
- **Funcionalidad**:
  - Configura el entorno de prueba real con base de datos
  - Proporciona métodos para configurar y limpiar la base de datos
  - Facilita pruebas que requieren conexión real a la base de datos

## Uso Recomendado

Las clases abstractas deben ser extendidas por las clases de prueba específicas:

```java
@SpringBootTest
public class StatusControllerTests extends SpringBootBaseTest {
    // Implementación de pruebas específicas
}
```

## Beneficios

1. **Reutilización**: Evita duplicar configuración común en múltiples clases de prueba
2. **Consistencia**: Garantiza que todas las pruebas sigan el mismo patrón de configuración
3. **Mantenimiento**: Cambios en la configuración pueden hacerse en una sola ubicación
4. **Claridad**: El propósito de cada clase abstracta está claramente definido
