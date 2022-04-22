package bbdd;

import modelos.*;

import java.sql.*;

public class EmpleadoBD {

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM kafu.empleado where id=?";
    private static final String SQL_CREATE = "INSERT INTO kafu.empleado (id, nombre, apellido, dni, numero_empleado, tipo_empleado) values(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE kafu.empleado SET nombre=?, apellido=?, dni=?, numero_empleado=?, tipo_empleado=? where id=?";
    private static final String SQL_DELETE = "DELETE from kafu.empleado where id=? ";

    public static Empleado getEmpleadoById(Integer id) {

        Connection conexion = UtilidadesBD.getConnection();
        Empleado empleado = null;

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_SELECT_BY_ID);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                empleado = new Empleado(
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("dni"), rs.getString("numero_empleado"), TipoEmpleado.valueOf(rs.getString("tipo_empleado"))
                );
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

        return empleado;

    }

    public static void CreateOrUpdateEmpleado(Empleado empleado) {
        Empleado empleadoRegistrado = getEmpleadoById(empleado.getId());
        if (empleadoRegistrado != null) {
            updateEmpleado(empleado);
        } else {
            createEmpleado(empleado);
        }
    }

    public static void createEmpleado(Empleado empleado) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_CREATE);
            query.setInt(1, empleado.getId());
            query.setString(2, empleado.getNombre());
            query.setString(3, empleado.getApellido());
            query.setString(4, empleado.getDni());
            query.setString(5, empleado.getNumeroEmpleado());
            query.setString(6, String.valueOf(empleado.getTipoEmpleado()));
            query.executeQuery();
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

    public static void updateEmpleado(Empleado empleado) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_UPDATE);
            query.setString(1, empleado.getNombre());
            query.setString(2, empleado.getApellido());
            query.setString(3, empleado.getDni());
            query.setString(4, empleado.getNumeroEmpleado());
            query.setString(5, String.valueOf(empleado.getTipoEmpleado()));
            query.setInt(6, empleado.getId());
            query.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

    public static void deleteEmpleado(Empleado empleado) {

        Connection conexion = UtilidadesBD.getConnection();

        try {
            PreparedStatement query = conexion.prepareStatement(SQL_DELETE);
            query.setInt(1, empleado.getId());
            query.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
        } finally {
            UtilidadesBD.closeConnection(conexion);
        }

    }

}
