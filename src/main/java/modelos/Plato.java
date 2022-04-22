package modelos;

import java.util.Objects;

public class Plato {

    private int id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private TipoPlato tipoPlato;

    public Plato() {
    }

    public Plato(Plato plato) {
        this.id =plato.getId();
        this.nombre = plato.getNombre();
        this.descripcion = plato.getDescripcion();
        this.precio = plato.getPrecio();
        this.tipoPlato = plato.getTipoPlato();
    }

    public Plato(int id, String nombre, String descripcion, double precio, TipoPlato tipoPlato) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoPlato = tipoPlato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoPlato getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plato plato = (Plato) o;
        return id == plato.id && Double.compare(plato.precio, precio) == 0 && Objects.equals(nombre, plato.nombre) && Objects.equals(descripcion, plato.descripcion) && tipoPlato == plato.tipoPlato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, tipoPlato);
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipoPlato=" + tipoPlato +
                '}';
    }

}
