# ShopSoft - Spring Boot | GA7-220501096-AA3-EV01

Módulo web de inventario desarrollado con Spring Boot, Spring MVC, Spring Data JPA, Thymeleaf y MariaDB.

## Requisitos
- JDK 21
- Maven
- XAMPP/MariaDB iniciado y base de datos `supermercado` disponible.

## Configuración
Revisar `src/main/resources/application.properties`. La configuración inicial es localhost:3306, base `supermercado`, usuario `root`, contraseña vacía. El servidor usa el puerto 8081 para no chocar con el Tomcat anterior. `ddl-auto=none` evita modificar la estructura existente.

## Ejecutar
Desde esta carpeta:
```powershell
mvn clean spring-boot:run
```
Abrir http://localhost:8081/productos

## Funcionalidades
Consultar, registrar, actualizar y eliminar productos. La categoría predeterminada es 1 (Granos), igual que en el módulo anterior.
