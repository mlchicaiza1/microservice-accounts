# Microservice Cuentas

Microservicio encargado de la gestión de cuentas y transacciones bancarias.

## Versión


- **Java:** 24
- **Spring Boot:** 3.4.1

## Estructura del Proyecto

Se utliza una arquitectura en capas:

- **contracts**: Interfaces que definen los contratos de los servicios.
- **controller**: Controladores REST que exponen los endpoints de la API.
- **domain**: Entidades del dominio que representan las tablas de la base de datos (JPA).
- **dto**: Objetos de Transferencia de Datos (DTOs) para la comunicación entre capas y con el cliente.
- **mapper**: Interfaces de MapStruct para el mapeo entre Entidades y DTOs.
- **repository**: Interfaces de repositorio (Spring Data JPA) para el acceso a datos.
- **service**: Implementación de la lógica de negocio.

## Tecnologías Principales

- Java 24
- Spring Boot 3.4.1
- Spring Data JPA (PostgreSQL)
- MapStruct (Mapeo de objetos)
- Lombok (Reducción de código repetitivo)
- Maven (Gestión de dependencias)
