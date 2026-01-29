# Módulo Inventario

Este directorio contiene la implementación del módulo de inventario de la aplicación GestionAlquileres.

## Estructura del Módulo

El módulo inventario sigue la misma estructura que los demás módulos del sistema:

```
modules/inventory/
├── controller/     # Controladores REST para el módulo de inventario
├── service/        # Lógica de negocio del módulo de inventario e interfaces
├── repository/     # Interfaces de acceso a datos/JPA para el módulo de inventario
├── model/          # Entidades de base de datos del módulo de inventario
└── dto/            # Objetos de transferencia para el API del módulo de inventario
```

## Propósito

El módulo de inventario se encarga de gestionar el control y seguimiento del inventario de productos disponibles para alquiler. Incluye funcionalidades como:

- Registro y actualización de productos en inventario
- Seguimiento de disponibilidad de productos
- Gestión de cantidades disponibles
- Consultas sobre el estado del inventario

## Componentes Principales

### Controladores (controller/)
Contiene los endpoints REST que exponen las funcionalidades del módulo de inventario al exterior.

### Servicios (service/)
Implementa la lógica de negocio del módulo, incluyendo reglas de validación y procesamiento de datos.

### Repositorios (repository/)
Define las interfaces para el acceso a datos usando JPA/Hibernate.

### Modelos (model/)
Contiene las entidades de base de datos que representan los objetos del módulo de inventario.

### DTOs (dto/)
Define los objetos de transferencia de datos utilizados en las comunicaciones entre capas.

## Uso Recomendado

Para crear nuevas funcionalidades en el módulo de inventario:

1. Definir las entidades necesarias en `model/`
2. Crear interfaces de repositorio en `repository/` 
3. Implementar la lógica de negocio en `service/`
4. Crear controladores REST en `controller/` para exponer los endpoints
5. Definir DTOs necesarios en `dto/`

Este módulo sigue las mismas convenciones y buenas prácticas que los demás módulos del sistema.