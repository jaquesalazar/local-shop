# LocalShop — Aplicación Web Progresiva

## 1. Descripción del proyecto

LocalShop es una aplicación web progresiva (PWA) desarrollada con Java y Spring Boot para mostrar productos de negocios locales. Permite consultar un catálogo almacenado en una base de datos relacional, visualizar nombres, descripciones, precios e imágenes, adaptar la interfaz a diferentes dispositivos y consultar la ubicación mediante el navegador.

La aplicación utiliza renderizado del lado del servidor (SSR) con Thymeleaf e incorpora un Service Worker para almacenar en caché recursos y recuperar la última página disponible cuando no hay conexión.

## 2. Objetivo

Desarrollar una aplicación web progresiva que integre una base de datos relacional, arquitectura MVC, renderizado del lado del servidor, diseño adaptable y disponibilidad limitada sin conexión.

## 3. Tecnologías utilizadas

- **Java:** lenguaje de programación.
- **Spring Boot:** configuración e inicio de la aplicación.
- **Spring Web:** gestión de solicitudes HTTP.
- **Thymeleaf:** generación de HTML dinámico en el servidor.
- **Spring Data JPA:** acceso a la base de datos mediante entidades y repositorios.
- **H2 Database:** almacenamiento relacional de los productos.
- **HTML y CSS:** estructura y presentación de la interfaz.
- **Bootstrap:** apoyo para el diseño adaptable.
- **JavaScript:** geolocalización y registro del Service Worker.
- **Service Worker:** almacenamiento en caché y recuperación de recursos.
- **Web App Manifest:** configuración de la instalación de la PWA.
- **Maven:** gestión de dependencias y compilación.

## 4. Estructura y componentes principales

El proyecto utiliza una organización basada en MVC (Modelo-Vista-Controlador), separando los datos, la lógica de atención de solicitudes y la presentación.

| Archivo o componente | Función |
|---|---|
| `LocalShopApplication.java` | Punto de entrada que inicia Spring Boot. |
| `model/Producto.java` | Define la entidad Producto y sus atributos, relacionados con la tabla de productos. |
| `repository/ProductoRepository.java` | Proporciona operaciones de consulta y persistencia mediante Spring Data JPA. |
| `controller/ProductoController.java` | Atiende la ruta principal, consulta los productos y los envía a la plantilla. |
| `templates/index.html` | Vista Thymeleaf que genera el catálogo HTML en el servidor. |
| `application.properties` | Configura la conexión a H2 y las opciones de persistencia de JPA. |
| `static/manifest.json` | Define el nombre, los colores, el modo de visualización y los iconos de la PWA. |
| `static/sw.js` | Gestiona la caché de la página y los recursos configurados para facilitar el acceso offline. |
| `static/icons/` | Contiene los iconos utilizados por el manifiesto. |
| `static/images/` | Contiene las imágenes de los productos. |

### Renderizado del lado del servidor (SSR)

Cuando el navegador solicita la página principal, el controlador consulta los productos mediante el repositorio. Después, Thymeleaf utiliza la plantilla `index.html` para generar el HTML con los datos recibidos. Así, el navegador obtiene una página que ya contiene el catálogo renderizado por el servidor.

## 5. Funcionalidades implementadas

- **Catálogo dinámico:** consulta y muestra los productos almacenados en H2.
- **Información de productos:** presenta nombre, descripción, precio e imagen.
- **Estado vacío:** muestra un mensaje cuando no hay productos registrados.
- **Diseño adaptable:** organiza el catálogo para pantallas de computadoras y dispositivos móviles.
- **Geolocalización:** solicita al navegador las coordenadas del dispositivo con autorización del usuario.
- **Indicador de conexión:** informa si el navegador detecta conexión de red.
- **Instalación como PWA:** utiliza el manifiesto y los iconos para configurar la instalación.
- **Funcionamiento offline:** permite recuperar la última página almacenada y los recursos disponibles en caché.

El modo offline no permite realizar automáticamente nuevas consultas a H2 ni guardar modificaciones en la base de datos. El contenido mostrado sin conexión corresponde a lo que se haya almacenado previamente.

## 6. Fases de desarrollo

### Fase 1. Configuración del proyecto

Se creó el proyecto Java con Spring Boot y se incorporaron las dependencias necesarias para la aplicación web, las plantillas Thymeleaf y el acceso a la base de datos.

**Evidencia:** estructura del proyecto y archivos de configuración.

### Fase 2. Modelo, repositorio y controlador

Se creó la entidad `Producto`, el repositorio para acceder a sus registros y el controlador encargado de consultar los productos y enviarlos a la vista principal.

**Evidencias del comportamiento del catálogo:**
- `docs/evidencias/01-catalogo-vacio.png`
- `docs/evidencias/02-catalogo-03productos.png`
- `docs/evidencias/03-catalogo-vacio-pag.png`
- `docs/evidencias/04-catalogo-03productos-pag.png`

### Fase 3. Integración de la base de datos

Se configuró H2 mediante `application.properties` y se registraron productos con sus descripciones, precios y rutas de imágenes. Se verificó que los registros se reflejaran en el catálogo.

**Evidencias:**
- `docs/evidencias/02-catalogo-03productos.png`
- `docs/evidencias/05-catalogo-seis-productos.png`
- `docs/evidencias/06-catalogo-seis-productos-pag.png`

### Fase 4. Desarrollo de la interfaz SSR

Se creó la plantilla `index.html` con Thymeleaf para presentar dinámicamente los productos consultados por el servidor. Se añadieron las imágenes, los precios y el mensaje para el catálogo vacío.

**Evidencias:**
- `docs/evidencias/01-catalogo-vacio.png`
- `docs/evidencias/03-catalogo-vacio-pag.png`
- `docs/evidencias/04-catalogo-03productos-pag.png`
- `docs/evidencias/06-catalogo-seis-productos-pag.png`

### Fase 5. Configuración de la PWA

Se incorporó `manifest.json` con los datos de instalación y los iconos. También se configuró `sw.js` para almacenar recursos en caché y recuperar la página cuando no hay conexión.

**Evidencias:**
- `docs/evidencias/11-manifes.png`
- `docs/evidencias/12-service-worker.png`
- `docs/evidencias/13-cache.png`

### Fase 6. Pruebas de funcionamiento

Se realizaron pruebas para comprobar el comportamiento de la aplicación con conexión y sin conexión, su adaptación a dispositivos móviles y el acceso a la geolocalización mediante los permisos del navegador.

También se verificó que el Service Worker pudiera recuperar contenido previamente almacenado en caché cuando la aplicación no tenía acceso a la red.

**Evidencias:**
- `docs/evidencias/07-estado-en-linea.png`
- `docs/evidencias/08-estado-offline.png`
- `docs/evidencias/09-vista-movil.png`
- `docs/evidencias/10-geolocalizacion.png`

## 7. Requisitos

Para ejecutar el proyecto se necesita:

- Java JDK 21 o una versión compatible.
- Maven, o utilizar el Maven Wrapper incluido en el proyecto.
- Un navegador web actualizado.

## 8. Instalación y ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/jaquesalazar/local-shop.git
   ```

2. Entrar en la carpeta del proyecto:

   ```bash
   cd local-shop
   ```

3. Ejecutar la aplicación con Maven Wrapper:

   En Windows:

   ```bash
   mvnw.cmd spring-boot:run
   ```

   En Linux o macOS:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Abrir la aplicación en el navegador:

   ```text
   http://localhost:8080
   ```

## 9. Base de datos

La aplicación utiliza H2 Database para almacenar los productos del catálogo. La configuración de conexión se encuentra en `application.properties`.

La base de datos utiliza almacenamiento en archivo, por lo que los registros pueden conservarse entre ejecuciones de la aplicación. La carpeta `data/` contiene los archivos locales de la base de datos y está excluida del repositorio mediante `.gitignore`.

Para consultar la consola de H2, iniciar la aplicación y acceder a:

```text
http://localhost:8080/h2-console
```

## 10. Manifiesto, Service Worker y funcionamiento offline

El archivo `manifest.json` define los datos necesarios para identificar e instalar LocalShop como una PWA, incluyendo el nombre, los colores, el modo de visualización y los iconos.

El archivo `sw.js` administra el almacenamiento en caché de la página principal y de los recursos solicitados. Cuando existe conexión, permite actualizar el contenido almacenado; cuando no hay conexión, intenta recuperar la última versión disponible en caché.

Esta funcionalidad ofrece disponibilidad limitada sin conexión. No sustituye la conexión con la base de datos ni permite realizar nuevas operaciones sobre ella mientras el servidor no esté disponible.

## 11. Repositorio

El código fuente y los archivos del proyecto se encuentran disponibles en GitHub:

[https://github.com/jaquesalazar/local-shop](https://github.com/jaquesalazar/local-shop)

## 12. Autores

- Jaqueline Salazar 
- Alexandro De la Vega Rodriguez
- Ana Sofia Peréz Ortega
- Erick Noel Aguilar Chavarría
- Moira Villalobos Hinojos
- Valeria Castillo López