# User Management Service

Este microservicio es una parte fundamental de la arquitectura de una plataforma de comercio electrónico. Su objetivo principal es gestionar los usuarios, incluyendo funcionalidades como:

- Registro de usuarios.
- Autenticación y control de acceso.
- Gestión de direcciones asociadas a los usuarios.

El servicio está diseñado siguiendo principios de **Domain-Driven Design (DDD)**, **Test-Driven Development (TDD)** y **Behavior-Driven Development (BDD)**, asegurando un código limpio, modular y bien probado.

---

## 📦 Tecnologías

Este proyecto utiliza las siguientes tecnologías:

- **Java 17**: Lenguaje principal para el desarrollo.
- **Spring Boot 3**: Framework para la creación de aplicaciones empresariales.
- **Maven**: Herramienta de gestión de dependencias y construcción.
- **PostgreSQL**: Base de datos relacional para persistencia.
- **Docker**: Contenerización para facilitar la implementación.
- **SonarQube**: Análisis de calidad del código.
- **GitHub Actions**: Integración y entrega continua (CI/CD).
- **DDD, BDD, TDD**: Enfoques de diseño y desarrollo.

---

## 📁 Estructura del proyecto

La estructura del proyecto sigue las mejores prácticas para aplicaciones basadas en Spring Boot:

```
user-management-service/
├── src/
│   ├── main/
│   │   ├── java/com/eci/arcn/user/
│   │   │   ├── application/  # Casos de uso y lógica de aplicación
│   │   │   ├── domain/       # Modelos de dominio y repositorios
│   │   │   ├── infrastructure/ # Controladores, persistencia y excepciones
│   │   └── resources/        # Configuración y recursos estáticos
│   └── test/                 # Pruebas unitarias y de integración
├── Dockerfile                # Configuración para construir la imagen Docker
├── docker-compose.yml        # Orquestación de contenedores
├── sonar-project.properties  # Configuración para SonarQube
├── pom.xml                   # Configuración de Maven
└── README.md                 # Documentación del proyecto
```

---

## 🚀 Cómo ejecutar

### Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Docker** y **Docker Compose**.
- **JDK 17**.
- **Maven 3.8+**.

### Pasos para ejecutar localmente

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/SebasBarrera/user-management-service.git
   cd user-management-service
   ```

2. **Construir el proyecto**:

   Ejecuta el siguiente comando para compilar el código y ejecutar las pruebas:

   ```bash
   mvn clean install
   ```

3. **Ejecutar con Docker**:

   Usa Docker Compose para construir y ejecutar los contenedores:

   ```bash
   docker-compose up --build
   ```

4. **Acceder a la aplicación**:

   Una vez que los contenedores estén en ejecución, puedes acceder a la API en:

   ```
   http://localhost:8080/api/users
   ```

---

## ✅ Pruebas

El proyecto incluye pruebas unitarias y de integración para garantizar la calidad del código. Para ejecutar las pruebas, utiliza el siguiente comando:

```bash
mvn test
```

---

## 📚 Documentación de la API

### Endpoints principales

#### Registrar un usuario

- **URL**: `/api/usuarios/registrar`
- **Método**: `POST`
- **Cuerpo de la solicitud**:

  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "contraseñaSegura"
  }
  ```

- **Respuesta exitosa**:

  ```json
  {
    "id": "uuid-del-usuario",
    "email": "usuario@ejemplo.com"
  }
  ```

- **Errores posibles**:
  - `400 Bad Request`: Si el email ya está registrado o los datos son inválidos.

---

## 🛠️ Desarrollo

### Configuración de SonarQube

Para analizar la calidad del código con SonarQube, asegúrate de tener un servidor SonarQube en ejecución y configura las credenciales en el archivo `sonar-project.properties`.

### Integración continua

El proyecto utiliza **GitHub Actions** para ejecutar pruebas y análisis de calidad automáticamente en cada commit.

---

## 🧑‍💻 Contribuciones

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad o corrección de errores (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y asegúrate de que las pruebas pasen.
4. Envía un pull request.

---

## 📄 Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).

---

## 👩‍💻 Autores

Desarrollado por : 

- Juan Camilo Angel Hernandez
- Juan Sebastian Barrera Pulido
- Laura Valentina Rodriguez Ortegon

