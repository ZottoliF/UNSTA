# Informe Técnico - Plataforma de Bienestar Integral

## Decisiones de Diseño

### 1. **Arquitectura del Sistema**
 Adopté una arquitectura **basada en servicios REST** utilizando **Spring Boot** como framework principal. Esta elección permitió una separación clara entre las capas de controladores, servicios y repositorios, lo que facilita el mantenimiento y escalabilidad del proyecto.
 
Al estructurar el proyecto en servicios **REST**, se facilita la ampliación futura, permitiendo añadir más servicios sin afectar el núcleo del sistema. Al seguir el estándar REST, la integración con otros sistemas externos y clientes es más simple.

### 2. **MongoDB**
 Decidí utilizar **MongoDB** como base de datos NoSQL debido a la naturaleza dinámica de los datos, como el historial de actividades y metas de los usuarios, los cuales no tienen un esquema rígido y pueden cambiar con el tiempo. MongoDB proporciona una estructura de documentos flexible que permite almacenar y consultar datos sin necesidad de adherirse a un esquema .

### 3. **Diseño de Clases y Entidades**
Diseñé las entidades principales siguiendo los requerimientos del proyecto. Cada entidad contiene atributos relacionados con su función en el sistema. Mantuve un diseño simple en las entidades, asegurando que cada clase represente un concepto claro dentro del dominio del sistema. Separar la lógica de negocio y la persistencia de datos dentro de servicios específicos permite la reutilización de código a través de muchos endpoints.

### 4. **Documentación con Swagger**
Integré Swagger para la autogeneración de documentación de la API. Esto facilita visualizar y probar los distintos endpoints de manera rápida y sin tener que crear documentación manual.

### 5. **Testing Unitario**
Decidí implementar pruebas unitarias para los endpoints principales usando **MockMvc** para simular peticiones HTTP y verificar el correcto funcionamiento de las rutas. Asegurar que los controladores y servicios funcionen correctamente antes de desplegar el sistema es crucial para mantener la calidad del software. Al automatizar las pruebas, se reducen los tiempos de validación manual y se mejora la capacidad de detectar errores antes de la implementación.

## Desafíos Encontrados y Soluciones

### 1. **Error de Swagger UI**
**Desafío**: Al intentar acceder a la documentación de Swagger UI, se presentó el error `StringIndexOutOfBoundsException`.

**Solución**: El problema se debía a un error en la versión de **springdoc-openapi-ui**. Se resolvió actualizando la dependencia en el archivo `pom.xml` a una versión más estable y compatible con el resto del sistema.

### 2. **Gestión de Datos Relacionales en MongoDB**
**Desafío**: Dado que MongoDB es una base de datos NoSQL, gestionar relaciones entre entidades como `Miembro` y sus metas, o `Instructor` y sus cursos creados, no es tan directo como en bases de datos relacionales.

**Solución**: Opté por utilizar referencias a objetos dentro de los documentos, lo que simplifica las relaciones y mantiene la integridad de los datos. Para relaciones más complejas, utilice consultas específicas en los servicios.

### 3. **Problemas con las Pruebas Unitarias**
**Desafío**: En las pruebas de los endpoints `GET` para obtener todos los registros, econtré un problema al simular el retorno de múltiples objetos.

**Solución**: Utilice la función `when(...).thenReturn(Arrays.asList(...))` para simular el retorno de listas en las pruebas unitarias, asegurando que los controladores manejen correctamente múltiples resultados.

### 4. **Pruebas falsas con mockito**
**Desafío**: Al realizar pruebas con Mockito, algunos test no fallaban cuando debían, dando la impresión de que todo estaba funcionando correctamente. El problema era que no se estaban validando las interacciones con los mocks de manera efectiva.

**Solución**: Se utilizó el método verify() de Mockito para asegurar que las interacciones esperadas con los mocks se estaban produciendo. Esto permitió que las pruebas validaran no solo el flujo de ejecución, sino también la correcta invocación de los métodos esperados.

#

El diseño con Spring Boot y MongoDB han facilitado el desarrollo de la plataforma. A través de la implementación de pruebas unitarias y la correcta separación de responsabilidades, el sistema garantiza un nivel de calidad adecuado para su despliegue. Los desafíos encontrados durante el proceso de desarrollo fueron resueltos mediante una combinación de actualización de dependencias, diseño adecuado de las entidades y pruebas exhaustivas.
