package bbdd;

import modelos.*;

import java.sql.*;

public class PlatoBD {

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM kafu.plato where id=?";
    private static final String SQL_CREATE = "INSERT INTO kafu.plato (id, nombre, descripcion, precio, tipo_plato) values(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE kafu.plato SET nombre=?, descripcion=?, precio=?, tipo_plato=? where id=?";
    private static final String SQL_DELETE = "DELETE from kafu.plato where id=? ";

    public static Plato getPlatoById(Integer id) {

        Connection conexion = UtilidadesBD.getConnection();
        Plato plato = null;

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_SELECT_BY_ID);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                plato = new Plato(
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getDouble("precio"), TipoPlato.valueOf(rs.getString("tipo_plato"))
                );
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

        return plato;

    }

    public static void CreateOrUpdatePlato(Plato plato) {
        Plato platoRegistrado = getPlatoById(plato.getId());
        if (platoRegistrado != null) {
            updatePlato(plato);
        } else {
            createPlato(plato);
        }
    }

    public static void createPlato(Plato plato) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_CREATE);
            query.setInt(1, plato.getId());
            query.setString(2, plato.getNombre());
            query.setString(3, plato.getDescripcion());
            query.setDouble(4, plato.getPrecio());
            query.setString(5, String.valueOf(plato.getTipoPlato()));
            query.executeQuery();
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

    public static void updatePlato(Plato plato) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_UPDATE);
            query.setString(1, plato.getNombre());
            query.setString(2, plato.getDescripcion());
            query.setDouble(3, plato.getPrecio());
            query.setString(4, String.valueOf(plato.getTipoPlato()));
            query.setInt(5, plato.getId());
            query.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

    public static void deletePlato(Plato plato) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_DELETE);
            query.setInt(1, plato.getId());
            query.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

}
