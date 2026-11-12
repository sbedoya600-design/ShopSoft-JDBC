
package com.shopsoft;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();
        Scanner entrada = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== SHOPSOFT JDBC =====");
            System.out.println("1. Consultar productos");
            System.out.println("2. Registrar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    productoDAO.consultarProductos();
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("ID categoría: ");
                    int categoria = entrada.nextInt();

                    System.out.print("Precio: ");
                    BigDecimal precio = entrada.nextBigDecimal();

                    System.out.print("Cantidad: ");
                    int cantidad = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Fecha vencimiento (AAAA-MM-DD, vacío si no aplica): ");
                    String fecha = entrada.nextLine();

                    Date vencimiento = fecha.isBlank()
                            ? null : Date.valueOf(fecha);

                    productoDAO.insertarProducto(
                            nombre, categoria, precio, cantidad, vencimiento);
                    break;

                case 3:
                    System.out.print("ID del producto: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = entrada.nextLine();

                    System.out.print("Nuevo precio: ");
                    BigDecimal nuevoPrecio = entrada.nextBigDecimal();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = entrada.nextInt();

                    productoDAO.actualizarProducto(
                            idActualizar, nuevoNombre,
                            nuevoPrecio, nuevaCantidad);
                    break;

                case 4:
                    System.out.print("ID del producto que desea eliminar: ");
                    int idEliminar = entrada.nextInt();

                    productoDAO.eliminarProducto(idEliminar);
                    break;

                case 0:
                    System.out.println("Finalizando ShopSoft JDBC...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}
