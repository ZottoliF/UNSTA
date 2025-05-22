# Informe Técnico - Sistema de Aprendizaje

## Decisiones de Diseño

### 1. **Arquitectura del Sistema**
Decidí adoptar una arquitectura **basada en servicios REST** utilizando **Spring Boot** como framework principal. Esta elección permite una separación clara entre las capas de controladores, servicios y repositorios, lo que mejora la mantenibilidad y escalabilidad del sistema. La utilización de servicios REST facilita la integración con otros sistemas externos y clientes, y garantiza que el sistema pueda ser ampliado fácilmente en el futuro sin afectar el núcleo de la aplicación.

### 2. **MongoDB como Base de Datos**
Opté por **MongoDB** como base de datos NoSQL debido a su naturaleza flexible y su capacidad para manejar datos no estructurados. En este sistema, las entidades como `Estudiante`, `Curso`, `Evaluacion`, `Instructor`, y `Leccion` pueden cambiar con el tiempo, y MongoDB permite gestionar estos cambios sin la necesidad de un esquema fijo, lo que es crucial para la evolución del sistema.

### 3. **Diseño de Clases y Entidades**
El diseño de las entidades está basado en los requisitos del sistema y la relación entre los diferentes objetos de dominio. Cada entidad fue diseñada para representar un concepto claro dentro del sistema, como los `Estudiantes`, `Instructores`, `Cursos` y `Evaluaciones`. Además, las relaciones entre las entidades fueron modeladas de manera flexible para poder adaptarse a futuras modificaciones, y se utilizaron referencias entre documentos para mantener la integridad de los datos.

### 4. **Documentación con Swagger**
Integré **Swagger** para la autogeneración de la documentación de la API. Esto permite a los desarrolladores y usuarios del sistema visualizar y probar rápidamente los diferentes endpoints sin la necesidad de crear documentación manualmente. Para acceder a la documentación, se puede ejecutar el proyecto y abrir la siguiente URL: **http://localhost:8080/swagger-ui**.

### 5. **Testing Unitario**
Implementé pruebas unitarias para los endpoints más críticos utilizando **MockMvc** para simular peticiones HTTP y verificar el correcto funcionamiento de los controladores. Estas pruebas aseguran que los controladores y servicios funcionen correctamente antes de desplegar el sistema, garantizando la calidad del software. El uso de pruebas automatizadas reduce el tiempo de validación manual y facilita la detección temprana de errores.

## Desafíos Encontrados y Soluciones

### 1. **Gestión de Datos Relacionales en MongoDB**
**Desafío**: Dado que MongoDB es una base de datos NoSQL, gestionar relaciones entre entidades como `Estudiante` y `Evaluacion`, o `Instructor` y `Curso` no es tan directo como en bases de datos relacionales. Esto ocasionó problemas de inconsistencia al intentar realizar operaciones de actualización o eliminación.

**Solución**: Utilicé **embebidos de documentos** y **referencias** para gestionar las relaciones. En particular, las evaluaciones de los estudiantes y los cursos de los instructores fueron modelados como referencias en lugar de relaciones directas, asegurando que la integridad de los datos se mantuviera incluso si se realizaban cambios o eliminaciones en las entidades relacionadas.

### 2. **Problemas con las Pruebas Unitarias en MongoDB**
**Desafío**: Durante las pruebas unitarias, encontré que algunas operaciones de la base de datos no se ejecutaban como se esperaba debido a la falta de un **entorno de prueba de MongoDB**. Algunas pruebas fallaban porque los documentos de la base de datos no se insertaban correctamente.

**Solución**: Implementé una configuración de base de datos en memoria para las pruebas utilizando **Embedded MongoDB** (`de.flapdoodle.embed.mongo`), lo que permitió simular un entorno de MongoDB en memoria para las pruebas sin necesidad de conectarse a una base de datos real. Esto resolvió los problemas de inconsistencia en las pruebas y permitió realizar pruebas unitarias más rápidas y aisladas.

### 3. **Pruebas Falsas con Mockito**
**Desafío**: Al realizar pruebas con Mockito, algunos test no fallaban cuando debían, dando la impresión de que todo estaba funcionando correctamente. El problema era que no se estaban validando las interacciones con los mocks de manera efectiva.

**Solución**: Utilicé el método `verify()` de Mockito para asegurar que las interacciones esperadas con los mocks se estaban produciendo. Esto permitió que las pruebas validaran no solo el flujo de ejecución, sino también la correcta invocación de los métodos esperados.

