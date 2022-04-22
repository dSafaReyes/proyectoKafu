import bbdd.EmpleadoBD;
import bbdd.PlatoBD;
import modelos.Empleado;
import modelos.Plato;
import modelos.TipoEmpleado;
import modelos.TipoPlato;

public class run {

    public static void main(String[] args) {

        Empleado empleado1 = new Empleado(1, "Javi", "Lopez", "21908367Q", "C0001", TipoEmpleado.CAMARERO);
        EmpleadoBD.CreateOrUpdateEmpleado(empleado1);

        Plato plato1  = new Plato(1, "Paella", "Un plato suculento.", 11.5, TipoPlato.PESCADO);
        PlatoBD.CreateOrUpdatePlato(plato1);

    }

}
