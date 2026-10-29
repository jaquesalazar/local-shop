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
- **Indicador de conexión:** informa si el navegador detecta conexión de red, cuando está disponible en la interfaz.
- **Instalación como PWA:** utiliza el manifiesto y los iconos para configurar la instalación.
- **Funcionamiento offline:** permite recuperar la última página almacenada y los recursos disponibles en caché.

El modo offline no permite realizar automáticamente nuevas consultas a H2 ni guardar modificaciones en la base de datos. El contenido mostrado sin conexión corresponde a lo que se haya almacenado previamente.

## 6. Fases de desarrollo

### Fase 1. Configuración del proyecto

Se creó el proyecto Java con Spring Boot y se incorporaron las dependencias necesarias para la aplicación web, las plantillas Thymeleaf y el acceso a la base de datos.

**Evidencia:** estructura del proyecto y archivos de configuración.

### Fase 2. Modelo, repositorio y controlador

Se creó la entidad `Producto`, el repositorio para acceder a sus registros y el controlador encargado de consultar los productos y enviarlos a la vista principal.

**Evidencias:**
- `docs/evidencias/01-catalogo-vacio.png`
- `docs/evidencias/02-catalogo-03-productos.png`
- `docs/evidencias/03-catalogo-vacio-pag.png`
- `docs/evidencias/04-catalogo-03-productos-pag.png`

### Fase 3. Integración de la base de datos

Se configuró H2 mediante `application.properties` y se registraron productos con sus descripciones, precios y rutas de imágenes.

**Evidencias relacionadas con el catálogo y los registros:**
- `docs/evidencias/02-catalogo-03-productos.png`
- `docs/evidencias/05-catalogo-seis-productos.png`
- `docs/evidencias/06-catalogo-seis-productos-pag.png`

### Fase 4. Desarrollo de la interfaz SSR

Se creó la plantilla `index.html` con Thymeleaf para presentar dinámicamente los productos consultados por el servidor. Se añadieron las imágenes, los precios y el mensaje para el catálogo vacío.

**Evidencias:**
- `docs/evidencias/01-catalogo-vacio.png`
- `docs/evidencias/03-catalogo-vacio-pag.png`
- `docs/evidencias/04-catalogo-03-productos-pag.png`
- `docs/evidencias/06-catalogo-seis-productos-pag.png`

### Fase 5. Configuración de la PWA

Se incorporó `manifest.json` con los datos de instalación y los iconos. También se configuró `sw.js` para almacenar recursos en caché y recuperar la página cuando no hay conexión.

**Evidencias:**
- `docs/evidencias/11-manifes.png`
- `docs/evidencias