# Implementación de Servicio de Status y Persistencia

Actúa como un experto en Spring Boot y Maven para implementar las siguientes tareas:

## 1. Configuración de Maven
- Modifica el `pom.xml` para incluir el goal `build-info` dentro del `spring-boot-maven-plugin` y pon un comentario indicando para que sirvre. Esto es necesario para que `BuildProperties` esté disponible.

## 2. Configuración de Base de Datos
- En `application.properties`, configura una base de datos H2 en memoria.
- Activa `spring.jpa.hibernate.ddl-auto=update`.

## 3. Modelo de Datos Mínimo
- Crea una entidad `SystemLog` con `id` (Long, auto-increment) y `timestamp` (LocalDateTime) para validar la conexión a la BD.

## 4. Controlador REST
- Crea un `StatusController` en el paquete `controller`.
- Inyecta el bean `BuildProperties`.
- Implementa un endpoint `GET /api/status` que devuelva un JSON con:
    - `nombre`: extraído de buildProperties.getName()
    - `version`: extraído de buildProperties.getVersion()
    - `status`: hardcoded como "OPERATIONAL"
    - `db_check`: un booleano que confirme si la base de datos responde.

## 5. Requisitos de Código
- Usa anotaciones de Lombok si están disponibles en el proyecto, si no, usa getters/setters estándar.
- Asegúrate de que el código siga las convenciones de nombres de Java.

## 6. Crear entornos:

- Variables de Entorno: Solicita que cree un archivo, por cada entorno siguiendo las configuraciones estandar de spring (application.properties, application-dev.properties ...).
- Aislamiento de Datos:  De los datos de la BD,  que cada una tenga una BD separada de sqlite
- Establezca por defecto el entorno sea el local, usando la propiedad "spring.profiles.active"
- Propósito de cada entorno:
* local: Desarrollo individual en la máquina del programador.
* dev: Integración continua de código del equipo.
* sit (System Integration Testing): Verificación de integraciones entre módulos.
* uat (User Acceptance Testing): Pruebas finales de usuario con datos similares a producción.
* prod: Entorno real de producción.
