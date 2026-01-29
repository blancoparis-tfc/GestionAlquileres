# GestionAlquileres
Pequeña herramienta para gestionar alquileres

## Funcionalidades Implementadas

### 1. Servicio de Status
- Configuración de Maven con build-info para BuildProperties
- Base de datos H2 en memoria
- Entidad SystemLog para validación de conexión a BD
- Controlador REST con endpoint /api/status que devuelve información del build y estado de la base de datos

### 2. Módulo de Inventario
- Entidad Inmueble con todos los campos definidos (referencia catastral, superficie, habitaciones, baños, etc.)
- Repositorio JPA para persistencia de datos
- Servicio con operaciones CRUD completas
- Controlador REST con endpoints:
  - GET /api/inventario/inmuebles - Listar todos los inmuebles
  - GET /api/inventario/inmuebles/{id} - Obtener un inmueble por ID
  - POST /api/inventario/inmuebles - Crear nuevo inmueble
  - PUT /api/inventario/inmuebles/{id} - Actualizar un inmueble
  - DELETE /api/inventario/inmuebles/{id} - Eliminar un inmueble

### 3. Entornos de Desarrollo
- Configuración para múltiples entornos (local, dev, sit, uat, prod)
- Aislamiento de datos con bases de datos SQLite separadas
- Configuración por defecto del entorno local

### 4. Estructura de Pruebas
- BaseTest con Faker para datos aleatorios en español
- SpringBootBaseTest para pruebas de integración
- MockMvcBaseTest para pruebas MVC
- IntegrationBaseTest para pruebas de integración con RestTestClient

### 5. Documentación API (Swagger/OpenAPI)
- Implementada la documentación de la API usando Swagger/OpenAPI 3
- Acceso a la interfaz de usuario en: `/swagger-ui.html`
- Descarga del archivo OpenAPI JSON en: `/v3/api-docs`
- Información detallada sobre los endpoints disponibles
