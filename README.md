# 🐾 Patitas Sin Hogar — Backend

**Patitas Sin Hogar** es una API REST desarrollada con **Java 21** y **Spring Boot 3** para gestionar un sistema de adopción de mascotas.  
Incluye funcionalidades para registrar y autenticar usuarios mediante **JWT**, publicar mascotas en adopción y administrar solicitudes de adopción.  
Desarrollado como **proyecto final** del curso de **Java** en **Coder House**.

---

## 🚀 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3**
    - Spring Web
    - Spring Data JPA
    - Spring Security
- **MySQL** (persistencia de datos)
- **Lombok** (reducción de boilerplate)
- **JWT** (JSON Web Token para autenticación)
- **SpringDoc OpenAPI** (documentación Swagger)
- **Maven** (gestión de dependencias)

---

## 📂 Estructura del Proyecto

- `entity/` → Entidades JPA (`Usuario`, `Mascota`, `Adopcion`)
- `dto/` → Objetos de transferencia de datos con validaciones
- `security/` → Lógica de autenticación y autorización con JWT
- `controller/` → Controladores REST
- `service/` → Servicios de negocio
- `repository/` → Interfaces JPA para acceso a datos
- `utils/` → Enumeraciones y utilidades

---

## 🔐 Seguridad y Autenticación

El sistema utiliza **Spring Security + JWT** para proteger los endpoints:

- `/auth/register` → Registro de usuario
- `/auth/login` → Inicio de sesión y obtención de token JWT

Los roles (`ERol`) permiten diferenciar usuarios administradores y comunes.

---

## 🐶 Entidades Principales

### Usuario
- Nombre, apellido, email, teléfono, fecha de registro
- Rol (`ADMIN` o `USER`)
- Relación con mascotas publicadas y adoptadas

### Mascota
- Nombre, especie, sexo, color de pelo, dirección, raza, peso, descripción, imagen, estado
- Relación con el usuario publicador

### Adopción
- Mascota adoptada
- Usuario publicador y adoptante
- Fecha de adopción

---

## 📄 Endpoints Principales

| Método | Endpoint                | Descripción |
|--------|------------------------|-------------|
| POST   | `/auth/register`       | Registrar usuario |
| POST   | `/auth/login`          | Iniciar sesión |
| GET    | `/mascotas`            | Listar mascotas |
| POST   | `/mascotas`            | Publicar mascota |
| PUT    | `/mascotas/{id}`       | Editar mascota |
| DELETE | `/mascotas/{id}`       | Eliminar mascota |
| POST   | `/adopciones`          | Registrar adopción |
| GET    | `/adopciones`          | Listar adopciones |

*(Estos endpoints pueden variar según la configuración final del proyecto)*

---

## 📦 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/patitas-sin-hogar-backend.git
   cd patitas-sin-hogar-backend
   ```

2. Configurar **application.properties**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/patitas
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=clave_secreta
   ```

3. Compilar y ejecutar:
   ```bash
   mvn spring-boot:run
   ```

4. Acceder a Swagger:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📌 Características Destacadas

- API REST con arquitectura en capas
- Validaciones con **Jakarta Validation**
- Seguridad basada en **JWT**
- DTOs para separar la capa de datos expuesta
- Documentación automática con **Swagger/OpenAPI**

---

## 📸 Video

[Ver Postman](https://drive.google.com/file/d/1G17HL4UDo5OSrc0B3Srl6cxGGFCNLw-W/view?usp=drive_link)

---

## 📜 Créditos

Desarrollado por **Maximiliano Soriano** 🧑‍💻  
Como parte de **Coder House | Java**.

---

## 📬 Contacto

Desarrollado por **Maximiliano Soriano** 🧑‍💻  
📧 Email: [maxi.soriano.70.23@gmail.com](mailto:maxi.soriano.70.23@gmail.com)  
🔗 LinkedIn: [linkedin.com/in/maximilianosoriano](https://www.linkedin.com/in/maximiliano-soriano/)
