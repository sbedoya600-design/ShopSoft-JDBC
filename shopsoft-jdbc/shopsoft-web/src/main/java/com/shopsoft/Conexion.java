package com.shopsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/supermercado";

    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public static Connection conectar() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el controlador MariaDB", e);
        }

        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}