# API REST de Comunidades para Kuiko

Este proyecto es una API REST pública para gestionar datos de comunidades, diseñada como una prueba técnica para Kuiko. Está desarrollada con **Spring Boot** y utiliza una base de datos **H2** en modo embebido para facilitar su clonación y ejecución.

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Endpoints](#endpoints)
- [Pruebas](#pruebas)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)

## Requisitos

Antes de empezar, asegúrate de tener instalado:
- **JDK 21** o superior
- **Apache Maven** (versión 3.8+)

## Configuración

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/diegol14/apirestPrueba.git
   cd apirestPrueba
   ```

2. **Instala las dependencias**:

   Ejecuta el siguiente comando en la raíz del proyecto para descargar las dependencias:

   ```bash
   mvn install
   ```

## Ejecución

Para ejecutar la aplicación en modo de desarrollo, utiliza el comando:

```bash
mvn spring-boot:run
```

Por defecto, la API estará disponible en `http://localhost:8080`.

## Endpoints

A continuación se listan algunos de los endpoints clave de la API:

- **GET /api/comunidades**: Obtiene una lista de comunidades.
- **POST /api/comunidades**: Crea una nueva comunidad.
- **PUT /api/comunidades/{id}**: Actualiza la comunidad especificada.
- **DELETE /api/comunidades/{id}**: Elimina la comunidad especificada.

> **Nota**: Para detalles completos sobre los endpoints y el formato de los datos, consulta la documentación OpenAPI generada automáticamente en `http://localhost:8080/swagger-ui.html` una vez la aplicación esté en ejecución.

## Pruebas

Esta aplicación incluye pruebas unitarias básicas. Para ejecutarlas, usa:

```bash
mvn test
```

## Tecnologías Utilizadas

- **Spring Boot 3.3.5**
- **Spring Data JPA** para la persistencia
- **H2 Database** en modo embebido
- **Lombok** para la reducción de código boilerplate
- **SpringDoc OpenAPI** para la documentación de la API

## Notas

- **DevTools**: La aplicación incluye Spring Boot DevTools para recarga en caliente durante el desarrollo.
- **H2 en Memoria**: La base de datos H2 está configurada en memoria (`application.properties`), lo cual permite que la aplicación funcione sin necesidad de una base de datos externa.

---

Este README tiene como objetivo facilitar a los evaluadores la configuración y ejecución de esta API. ¡Gracias por revisar este proyecto!
