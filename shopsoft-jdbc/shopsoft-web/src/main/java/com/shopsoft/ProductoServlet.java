
package com.shopsoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h1>ShopSoft - Productos</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Cantidad</th><th>Acciones</th></tr>");

        String sql = "SELECT id_producto, nombre, precio, cantidad FROM productos";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String precio = rs.getBigDecimal("precio").toString();
                int cantidad = rs.getInt("cantidad");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + nombre + "</td>");
                out.println("<td>" + precio + "</td>");
                out.println("<td>" + cantidad + "</td>");
                out.println("<td>");

                out.println("<form method='post' style='display:inline'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<input type='text' name='nombre' value='" + nombre + "' required>");
                out.println("<input type='number' step='0.01' name='precio' value='" + precio + "' required>");
                out.println("<input type='number' name='cantidad' value='" + cantidad + "' required>");
                out.println("<button name='accion' value='actualizar'>Actualizar</button>");
                out.println("<button name='accion' value='eliminar' onclick=\"return confirm('¿Eliminar este producto?')\">Eliminar</button>");
                out.println("</form>");

                out.println("</td></tr>");
            }

        } catch (Exception e) {
            out.println("<p>Error al consultar: " + e.getMessage() + "</p>");
        }

        out.println("</table>");
        out.println("<br><a href='index.html'>Volver al formulario</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        try (Connection con = Conexion.conectar()) {

            if ("actualizar".equals(accion)) {

                String sql = "UPDATE productos SET nombre=?, precio=?, cantidad=? WHERE id_producto=?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("nombre"));
                    ps.setBigDecimal(2, new java.math.BigDecimal(request.getParameter("precio")));
                    ps.setInt(3, Integer.parseInt(request.getParameter("cantidad")));
                    ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                    ps.executeUpdate();
                }

            } else if ("eliminar".equals(accion)) {

                String sql = "DELETE FROM productos WHERE id_producto=?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                    ps.executeUpdate();
                }

            } else {

                String sql = "INSERT INTO productos (nombre, id_categoria, precio, cantidad) VALUES (?, 1, ?, ?)";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("nombre"));
                    ps.setBigDecimal(2, new java.math.BigDecimal(request.getParameter("precio")));
                    ps.setInt(3, Integer.parseInt(request.getParameter("cantidad")));
                    ps.executeUpdate();
                }
            }

            response.sendRedirect("ProductoServlet");

        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
