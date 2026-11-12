# ShopSoft – Gestión de productos

## 1. Descripción
ShopSoft es un módulo web desarrollado en Java que permite gestionar los productos de un supermercado mediante conexión a una base de datos MariaDB.

## 2. Tecnologías utilizadas
- Java JDK 21.
- Apache Maven.
- Apache Tomcat 10.1.
- MariaDB.
- JDBC.
- Jakarta Servlet.
- HTML y JSP.

## 3. Funcionalidades
- Registrar productos.
- Consultar productos almacenados.
- Actualizar información de productos.
- Eliminar productos.
- Conectarse a la base de datos mediante JDBC.

## 4. Base de datos
El proyecto utiliza una base de datos MariaDB llamada `supermercado`.

La conexión se configura en la clase `Conexion.java`.

Parámetros de conexión:
- Servidor: localhost.
- Puerto: 3306.
- Base de datos: supermercado.
- Usuario: root.

Se debe configurar la contraseña según el entorno donde se ejecute el proyecto.

## 5. Instalación y ejecución
1. Instalar JDK 21, Maven y Apache Tomcat 10.1.
2. Iniciar Apache y MySQL/MariaDB desde XAMPP.
3. Verificar que exista la base de datos `supermercado` y sus tablas.
4. Abrir la carpeta `shopsoft-web` en Visual Studio Code.
5. Ejecutar en la terminal:

```bash
mvn clean package
```

6. Copiar el archivo generado `target/shopsoft-web.war` a la carpeta `webapps` de Tomcat.
7. Iniciar Tomcat.
8. Abrir en el navegador:

`http://localhost:8080/shopsoft-web/index.html`

## 6. Estructura del proyecto

- `src/main/java/com/shopsoft/`: clases Java y servlets.
- `src/main/webapp/`: archivos HTML y JSP.
- `pom.xml`: configuración y dependencias Maven.
- `target/`: archivos generados durante la compilación.

## 7. Autor
Proyecto académico desarrollado como evidencia del programa de formación Análisis y Desarrollo de Software del SENA.