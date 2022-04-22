package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilidadesBD {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "raiz";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.toString());;
        }
        return conexion;
    }

    public static void closeConnection(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error cerrando conexiones: " + e.toString());
        }
    }
}
