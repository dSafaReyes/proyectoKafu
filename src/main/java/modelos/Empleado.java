package modelos;


import java.util.Objects;

public class Empleado {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String numeroEmpleado;
    private TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.dni = empleado.getDni();
        this.numeroEmpleado = empleado.getNumeroEmpleado();
        this.tipoEmpleado = empleado.getTipoEmpleado();
    }

    public Empleado(Integer id, String nombre, String apellido, String dni, String numeroEmpleado, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroEmpleado = numeroEmpleado;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(dni, empleado.dni) && Objects.equals(numeroEmpleado, empleado.numeroEmpleado) && tipoEmpleado == empleado.tipoEmpleado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, numeroEmpleado, tipoEmpleado);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }

}
