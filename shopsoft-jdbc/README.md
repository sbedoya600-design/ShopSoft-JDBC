
# ShopSoft JDBC

## Descripción
Módulo de gestión de productos del sistema ShopSoft, desarrollado en Java con conexión JDBC a una base de datos MariaDB.

## Tecnologías utilizadas
- Java JDK 21
- Apache Maven
- JDBC
- MariaDB
- Visual Studio Code

## Funcionalidades
- Consultar productos.
- Registrar productos.
- Actualizar productos.
- Eliminar productos.

## Requisitos
- Tener instalado Java JDK 21.
- Tener Apache Maven.
- Tener XAMPP con MariaDB iniciado.
- Tener creada la base de datos `supermercado`.

## Configuración de conexión
La conexión se encuentra en `Conexion.java`.

- Servidor: localhost
- Puerto: 3306
- Base de datos: supermercado
- Usuario: root

## Ejecución
Desde la terminal, ubicarse en la carpeta del proyecto y ejecutar:

```bash
mvn clean compile
mvn exec:java "-Dexec.mainClass=com.shopsoft.Main"
```

## Autor
Proyecto académico – SENA  
Programa: Análisis y Desarrollo de Software
