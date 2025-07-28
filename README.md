# 🏥 API REST para Gestión de Pacientes y Turnos Médicos

API REST completa desarrollada en Spring Boot para la gestión eficiente de pacientes y turnos médicos en centros de salud. Este sistema implementa operaciones CRUD robustas, utiliza el patrón DTO para optimizar la transferencia de datos, emplea mappers para una conversión limpia entre capas, e incorpora un sistema integral de validaciones y manejo centralizado de excepciones.

El proyecto aplica las mejores prácticas de desarrollo con Spring Boot, demostrando una arquitectura en capas bien estructurada, relaciones JPA entre entidades, y un diseño orientado a la escalabilidad y mantenibilidad del código.

Este proyecto fue desarrollado como parte de las Prácticas Profesionalizantes de la Tecnicatura Universitaria en Programación de la Universidad Tecnológica Nacional (UTN).

## 📚 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring Data JPA**
- **Spring Validation**
- **MySQL Database**
- **Maven**
- **Lombok**
- **Jakarta Validation**

## 🎯 Objetivos del Ejercicio

- Implementar una API REST completa con Spring Boot
- Aplicar el patrón DTO para la transferencia de datos
- Utilizar mappers para la conversión entre capas
- Demostrar el uso de Spring Data JPA con relaciones
- Implementar validaciones robustas de datos
- Crear manejo centralizado de excepciones
- Desarrollar una estructura de proyecto robusta

## ✨ Funcionalidades

### 👤 Gestión de Pacientes
- Consultar todos los pacientes registrados
- Consultar paciente por ID específico
- Crear nuevos pacientes en el sistema
- Validación de DNI y email únicos

### 📅 Gestión de Turnos Médicos
- Consultar todos los turnos programados
- Consultar turno por ID específico
- Crear nuevos turnos médicos
- Consultar turnos por paciente
- Consultar turnos por especialidad médica
- Relación Many-to-One con pacientes

### �️ Características Técnicas
- Transferencia de datos optimizada con DTOs
- Mapeo automático entre entidades y DTOs
- Validaciones de entrada con Bean Validation
- Manejo centralizado de excepciones
- Base de datos persistente MySQL

## 🛠️ Tecnologías y Propósitos

| Tecnología | Propósito |
|------------|-----------|
| Spring Boot | Framework principal para desarrollo rápido |
| Spring Data JPA | Persistencia de datos y manejo de relaciones |
| Spring Web | Exposición de la API REST |
| Spring Validation | Validación de datos de entrada |
| JPA/Hibernate | ORM y mapeo objeto-relacional |
| Java 17 | Lenguaje de programación moderno |
| MySQL | Base de datos relacional persistente |
| Maven | Sistema de construcción y dependencias |
| Lombok | Reducción de código boilerplate |

## 🎓 Conceptos Aplicados

### 🏛️ Arquitectura en Capas
- **Controller**: Manejo de peticiones HTTP y definición de endpoints REST
- **Service**: Lógica de negocio y validaciones de dominio
- **Repository**: Acceso a datos mediante Spring Data JPA
- **Entity**: Modelo de dominio con anotaciones JPA y relaciones
- **Exception**: Manejo centralizado de errores y excepciones

### 📦 Patrón DTO (Data Transfer Object)
Separación de responsabilidades: los DTO encapsulan solo los datos necesarios para cada operación.
Se implementan dos tipos por entidad:

- **CreateDTO**: Para crear recursos (validaciones incluidas)
- **ResponseDTO**: Para mostrar recursos (datos optimizados para el cliente)

### 🔄 Mapper Pattern
- Conversión limpia entre capas (entidad ↔ DTO)
- Lógica de conversión centralizada en clases Mapper
- Mejora la reutilización de código y la mantenibilidad

### 🗃️ Spring Data JPA
- Uso de JpaRepository para acceder a los datos
- Implementación automática de operaciones CRUD
- Relaciones @ManyToOne entre turnos y pacientes
- Consultas personalizadas con métodos derivados

### 🌐 API REST
- Uso correcto de métodos HTTP (GET, POST)
- Serialización/deserialización automática de JSON
- Códigos de estado HTTP apropiados
- Inyección de dependencias por constructor

### 🛡️ Validaciones y Excepciones
- Validaciones con Jakarta Validation (@Valid, @NotBlank, @Email)
- Manejo global de excepciones con @RestControllerAdvice
- Respuestas de error consistentes y descriptivas

## 🏗️ Arquitectura

```
📁 src/main/java/com/example/clinica/
├── 📁 controller/     # Controladores REST
├── 📁 dto/           # Data Transfer Objects
├── 📁 entities/      # Entidades JPA
├── 📁 exception/     # Manejo de excepciones
├── 📁 mapper/        # Mapeo entre DTOs y entidades
├── 📁 repository/    # Repositorios JPA
├── 📁 service/       # Lógica de negocio
└── ClinicManagementApiApplication
```

## 🧩 Entidades

### 👤 Paciente
- `id` (Long) - Identificador único
- `nombre` (String) - Nombre del paciente
- `apellido` (String) - Apellido del paciente
- `dni` (String) - DNI único
- `email` (String) - Email único

### 📆 Turno
- `id` (Long) - Identificador único
- `fecha` (LocalDateTime) - Fecha y hora del turno
- `especialidad` (String) - Especialidad médica
- `medico` (String) - Nombre del médico
- `paciente` (Paciente) - Relación @ManyToOne

## 📊 Endpoints Disponibles

### 👤 Pacientes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/pacientes` | Lista todos los pacientes |
| `POST` | `/api/pacientes` | Crea un nuevo paciente |
| `GET` | `/api/pacientes/{id}` | Obtiene un paciente por ID |

### 📆 Turnos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/turnos` | Lista todos los turnos |
| `POST` | `/api/turnos` | Crea un nuevo turno |
| `GET` | `/api/turnos/{id}` | Obtiene un turno por ID |
| `GET` | `/api/turnos/paciente/{pacienteId}` | Turnos de un paciente |
| `GET` | `/api/turnos/especialidad/{especialidad}` | Turnos por especialidad |

## 📦 DTOs

### PacienteCreateDTO
```json
{
  "nombre": "María",
  "apellido": "González",
  "dni": "87654321",
  "email": "maria.gonzalez@email.com"
}
```

### PacienteResponseDTO
```json
{
  "id": 1,
  "nombreCompleto": "María González",
  "email": "maria.gonzalez@email.com",
  "dni": "87654321"
}
```

### TurnoCreateDTO
```json
{
  "fecha": "2025-07-30T10:30:00",
  "especialidad": "Cardiología",
  "medico": "Dr. López",
  "idPaciente": 1
}
```

### TurnoResponseDTO
```json
{
  "id": 1,
  "fecha": "2025-07-30T10:30:00",
  "especialidad": "Cardiología",
  "medico": "Dr. López",
  "pacienteNombre": "María González",
  "pacienteId": 1
}
```

## � Ejemplos de Uso

### 👤 Gestión de Pacientes

#### 📌 Crear un paciente
```http
POST http://localhost:8080/api/pacientes
Content-Type: application/json

{
  "nombre": "María",
  "apellido": "González",
  "dni": "87654321",
  "email": "maria.gonzalez@email.com"
}
```

**Respuesta esperada (201 Created):**
```json
{
  "id": 1,
  "nombreCompleto": "María González",
  "email": "maria.gonzalez@email.com",
  "dni": "87654321"
}
```

#### 📌 Obtener todos los pacientes
```http
GET http://localhost:8080/api/pacientes
```

**Respuesta esperada:**
```json
[
  {
    "id": 1,
    "nombreCompleto": "María González",
    "email": "maria.gonzalez@email.com",
    "dni": "87654321"
  },
  {
    "id": 2,
    "nombreCompleto": "Carlos Rodríguez",
    "email": "carlos.rodriguez@email.com",
    "dni": "11223344"
  }
]
```

#### 📌 Obtener paciente por ID
```http
GET http://localhost:8080/api/pacientes/1
```

### � Gestión de Turnos

#### 📌 Crear un turno médico
```http
POST http://localhost:8080/api/turnos
Content-Type: application/json

{
  "fecha": "2025-07-30T10:30:00",
  "especialidad": "Cardiología",
  "medico": "Dr. López",
  "idPaciente": 1
}
```

**Respuesta esperada (201 Created):**
```json
{
  "id": 1,
  "fecha": "2025-07-30T10:30:00",
  "especialidad": "Cardiología",
  "medico": "Dr. López",
  "pacienteNombre": "María González",
  "pacienteId": 1
}
```

#### 📌 Obtener turnos por paciente
```http
GET http://localhost:8080/api/turnos/paciente/1
```

#### 📌 Obtener turnos por especialidad
```http
GET http://localhost:8080/api/turnos/especialidad/Cardiología
```

### 🧪 Pruebas con Postman

#### Configuración inicial:
1. **Crear Environment**: `Clinica Local`
2. **Agregar Variable**: 
   - **Variable**: `baseUrl`
   - **Value**: `http://localhost:8080/api`
3. **Activar Environment** en el dropdown

#### Secuencia de pruebas recomendada:

**1. Crear Pacientes (POST)**
```
URL: {{baseUrl}}/pacientes
Method: POST
Headers: Content-Type: application/json
Body:
{
  "nombre": "Ana",
  "apellido": "Silva",
  "dni": "33445566",
  "email": "ana.silva@email.com"
}
```

**2. Crear Segundo Paciente (POST)**
```
URL: {{baseUrl}}/pacientes
Method: POST
Headers: Content-Type: application/json
Body:
{
  "nombre": "Carlos",
  "apellido": "Rodríguez",
  "dni": "11223344", 
  "email": "carlos.rodriguez@email.com"
}
```

**3. Listar Pacientes (GET)**
```
URL: {{baseUrl}}/pacientes
Method: GET
```

**4. Crear Turno (POST)**
```
URL: {{baseUrl}}/turnos
Method: POST
Headers: Content-Type: application/json
Body:
{
  "fecha": "2025-08-01T15:30:00",
  "especialidad": "Dermatología",
  "medico": "Dra. Martínez",
  "idPaciente": 1
}
```

**5. Listar Turnos (GET)**
```
URL: {{baseUrl}}/turnos
Method: GET
```

**6. Turnos por Paciente (GET)**
```
URL: {{baseUrl}}/turnos/paciente/1
Method: GET
```

**7. Turnos por Especialidad (GET)**
```
URL: {{baseUrl}}/turnos/especialidad/Dermatología
Method: GET
```

#### Casos de prueba de validación:

**Error de validación - Email inválido:**
```
URL: {{baseUrl}}/pacientes
Method: POST
Body:
{
  "nombre": "Test",
  "apellido": "User",
  "dni": "98765432",
  "email": "email-invalido"
}
```

**Error de DNI duplicado:**
```
URL: {{baseUrl}}/pacientes
Method: POST
Body:
{
  "nombre": "Otro",
  "apellido": "Paciente",
  "dni": "33445566",
  "email": "otro@email.com"
}
```

**Error de paciente inexistente:**
```
URL: {{baseUrl}}/turnos
Method: POST
Body:
{
  "fecha": "2025-08-01T10:00:00",
  "especialidad": "Test",
  "medico": "Dr. Test",
  "idPaciente": 999
}
```

## 🗃️ Base de Datos

### Configuración MySQL
- **Base de datos**: `clinica_db`
- **Puerto**: 3306
- **Usuario**: root
- **URL**: `jdbc:mysql://localhost:3306/clinica_db`

### Estructura de Tablas

#### Tabla: pacientes
- `id` (BIGINT, AUTO_INCREMENT, PRIMARY KEY)
- `nombre` (VARCHAR, NOT NULL)
- `apellido` (VARCHAR, NOT NULL)  
- `dni` (VARCHAR, UNIQUE, NOT NULL)
- `email` (VARCHAR, UNIQUE, NOT NULL)

#### Tabla: turnos
- `id` (BIGINT, AUTO_INCREMENT, PRIMARY KEY)
- `fecha` (DATETIME, NOT NULL)
- `especialidad` (VARCHAR, NOT NULL)
- `medico` (VARCHAR, NOT NULL)
- `paciente_id` (BIGINT, FOREIGN KEY)

## 🚀 Ejecución del Proyecto

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+
- MySQL Server
- MySQL Workbench (opcional)

### Pasos de instalación
1. **Clonar el repositorio**
2. **Crear base de datos**: `CREATE DATABASE clinica_db;`
3. **Configurar conexión** en `application.properties`
4. **Compilar**: `mvn clean compile`
5. **Ejecutar**: `mvn spring-boot:run`

La aplicación estará disponible en: `http://localhost:8080`

## 🧪 Datos de Prueba

La aplicación incluye datos de prueba que se cargan automáticamente al iniciar:
- **3 pacientes** de ejemplo
- **4 turnos médicos** de ejemplo

## 🛡️ Manejo de Errores

### Ejemplos de respuestas de error:

#### Validación (400 Bad Request):
```json
{
  "code": "VALIDATION_ERROR",
  "message": "Error en la validación de datos",
  "errors": {
    "email": "El email debe tener un formato válido"
  },
  "timestamp": "2025-07-28T..."
}
```

#### Recurso no encontrado (404 Not Found):
```json
{
  "code": "RESOURCE_NOT_FOUND",
  "message": "Paciente no encontrado con ID: 999",
  "timestamp": "2025-07-28T..."
}
```

#### DNI duplicado (400 Bad Request):
```json
{
  "code": "BAD_REQUEST",
  "message": "Ya existe un paciente con el DNI: 12345678",
  "timestamp": "2025-07-28T..."
}
```

## 📝 Notas

- La base de datos persiste entre ejecuciones
- Los datos de prueba se cargan automáticamente en el primer arranque
- MySQL Workbench disponible para inspección de datos
- CORS habilitado para desarrollo frontend

---

# 👨‍💻 Autor
Matías Sebastián Araya 
Estudiante de Tecnicatura Universitaria en Programación  
Universidad Tecnológica Nacional (UTN)(FRM)
