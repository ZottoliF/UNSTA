# Informe Técnico - Plataforma de Bienestar Integral

## Descripción del Proyecto
La Plataforma de Bienestar Integral es un sistema digital diseñado para gestionar los servicios de un centro de salud física y mental. El sistema permite a los usuarios reservar clases y sesiones de entrenamiento, hacer seguimiento de su progreso, y recibir recomendaciones personalizadas. Asimismo, los instructores pueden gestionar sus clases y consultar el historial de actividades de los miembros.

### Funcionalidades Principales:
- **Gestión de Servicios**: Los usuarios pueden explorar y reservar servicios como clases de meditación, entrenamientos físicos, consultas nutricionales, entre otros.
- **Asignación de Recursos**: Administración de instalaciones y recursos como equipos e instructores.
- **Seguimiento de Progreso**: Permite a los usuarios establecer metas y realizar un seguimiento de su avance en función de actividades previas.
- **Sistema de Recomendaciones Personalizadas**: El sistema sugiere actividades basadas en el perfil y progreso del usuario.

## Decisiones de Diseño

### 1. **Arquitectura del Sistema**
Se adoptó una arquitectura **basada en servicios REST** utilizando **Spring Boot** como framework principal. Esta elección permitió una separación clara entre las capas de controladores, servicios y repositorios, lo que facilita el mantenimiento y escalabilidad del proyecto.

#### Justificación:
- **Modularidad**: Al estructurar el proyecto en servicios REST, se facilita la ampliación futura, permitiendo añadir más servicios sin afectar el núcleo del sistema.
- **Facilidad de Integración**: Al seguir el estándar REST, la integración con otros sistemas externos y clientes (aplicaciones móviles o web) es más simple.

### 2. **Persistencia con MongoDB**
Se decidió utilizar **MongoDB** como base de datos NoSQL debido a la naturaleza dinámica de los datos, como el historial de actividades y metas de los usuarios, los cuales no tienen un esquema rígido y pueden cambiar con el tiempo.

#### Justificación:
- **Flexibilidad**: MongoDB proporciona una estructura de documentos flexible que permite almacenar y consultar datos sin necesidad de adherirse a un esquema fijo, ideal para los modelos del sistema como `Meta`, `Miembro` e `Instructor`.
- **Escalabilidad**: MongoDB está diseñado para manejar grandes cantidades de datos distribuidos, lo que es útil en caso de crecimiento del sistema y un número elevado de usuarios.

### 3. **Diseño de Clases y Entidades**
Se diseñaron las entidades principales siguiendo los requerimientos del proyecto, como `Miembro`, `Instructor`, `Meta` e `Instalacion`. Cada entidad contiene atributos relacionados con su función en el sistema.

#### Justificación:
- **Simplicidad**: Mantener un diseño simple en las entidades, asegurando que cada clase represente un concepto claro dentro del dominio del sistema.
- **Reutilización**: Separar la lógica de negocio y la persistencia de datos dentro de servicios específicos permite la reutilización de código a través de múltiples endpoints.

### 4. **Testing Unitario**
Se decidió implementar pruebas unitarias para los endpoints principales usando **JUnit** y **MockMvc** para simular peticiones HTTP y verificar el correcto funcionamiento de las rutas.

#### Justificación:
- **Confiabilidad**: Asegurar que los controladores y servicios funcionen correctamente antes de desplegar el sistema es crucial para mantener la calidad del software.
- **Eficiencia**: Al automatizar las pruebas, se reducen los tiempos de validación manual y se mejora la capacidad de detectar errores antes de la implementación.

## Desafíos Encontrados y Soluciones

### 1. **Error de Swagger UI**
**Desafío**: Al intentar acceder a la documentación de Swagger UI, se presentó el error `StringIndexOutOfBoundsException`.

**Solución**: El problema se debía a un error en la versión de **springdoc-openapi-ui**. Se resolvió actualizando la dependencia en el archivo `pom.xml` a una versión más estable y compatible con el resto del sistema.

### 2. **Gestión de Datos Relacionales en MongoDB**
**Desafío**: Dado que MongoDB es una base de datos NoSQL, gestionar relaciones entre entidades como `Miembro` y sus metas, o `Instructor` y sus cursos creados, no es tan directo como en bases de datos relacionales.

**Solución**: Se optó por utilizar referencias a objetos embebidos dentro de los documentos, lo que simplifica las relaciones y mantiene la integridad de los datos. Para relaciones más complejas, se utilizaron consultas específicas en los servicios.

### 3. **Problemas con las Pruebas Unitarias**
**Desafío**: En las pruebas de los endpoints `GET` para obtener todos los registros, se encontró un problema al simular el retorno de múltiples objetos.

**Solución**: Se utilizó la función `when(...).thenReturn(Arrays.asList(...))` para simular el retorno de listas en las pruebas unitarias, asegurando que los controladores manejen correctamente múltiples resultados.

### 4. **Manejo de la Capacidad en Instalaciones**
**Desafío**: Para las instalaciones, era necesario manejar el control de capacidad y evitar sobrepasar el límite en las reservas.

**Solución**: Se implementó una validación en el servicio de reservas que verifica la capacidad disponible antes de permitir que un usuario reserve una clase o sesión en una instalación determinada.

## Conclusiones

El diseño modular y la elección de tecnologías como Spring Boot y MongoDB han facilitado el desarrollo de una plataforma flexible y escalable. A través de la implementación de pruebas unitarias y la correcta separación de responsabilidades, el sistema garantiza un nivel de calidad adecuado para su despliegue. Los desafíos encontrados durante el proceso de desarrollo fueron resueltos mediante una combinación de actualización de dependencias, diseño adecuado de las entidades y pruebas exhaustivas.

Este enfoque ha permitido crear un sistema robusto, capaz de manejar tanto la gestión de usuarios e instructores, como la administración de recursos e instalaciones, asegurando una experiencia de usuario fluida y eficiente.
