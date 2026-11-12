
package com.shopsoft;

import java.sql.*;
import java.math.BigDecimal;

public class ProductoDAO {

    // CONSULTAR PRODUCTOS
    public void consultarProductos() {
        String sql = "SELECT * FROM productos";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- LISTADO DE PRODUCTOS ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_producto") + " | " +
                    rs.getString("nombre") + " | $" +
                    rs.getBigDecimal("precio") + " | " +
                    rs.getInt("cantidad")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // INSERTAR PRODUCTO
    public void insertarProducto(String nombre, int categoria,
            BigDecimal precio, int cantidad, Date vencimiento) {

        String sql = "INSERT INTO productos " +
                "(nombre, id_categoria, precio, cantidad, fecha_vencimiento) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, categoria);
            ps.setBigDecimal(3, precio);
            ps.setInt(4, cantidad);

            if (vencimiento == null) {
                ps.setNull(5, Types.DATE);
            } else {
                ps.setDate(5, vencimiento);
            }

            ps.executeUpdate();
            System.out.println("Producto registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // ACTUALIZAR PRODUCTO
    public void actualizarProducto(int id, String nombre,
            BigDecimal precio, int cantidad) {

        String sql = "UPDATE productos SET nombre=?, precio=?, cantidad=? " +
                "WHERE id_producto=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setBigDecimal(2, precio);
            ps.setInt(3, cantidad);
            ps.setInt(4, id);

            int filas = ps.executeUpdate();
            System.out.println(filas > 0
                    ? "Producto actualizado correctamente."
                    : "No se encontró el producto.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR PRODUCTO
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id_producto=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            System.out.println(filas > 0
                    ? "Producto eliminado correctamente."
                    : "No se encontró el producto.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
