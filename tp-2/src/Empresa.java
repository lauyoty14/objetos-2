import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class Empresa {
    protected String nombre;
    protected String CUIT;
    List<Empleado> empleados = new ArrayList<>();
    List<Recibo> recibos = new ArrayList<>();

    public Empresa(String nombre, String CUIT) {
        this.nombre = nombre;
        this.CUIT = CUIT;
    }

    public double totalSueldoNeto(){
        return empleados.stream().mapToDouble(Empleado::sueldoNeto).sum();
    }

    public double totalSueldoBruto(){
        return empleados.stream().mapToDouble(Empleado::sueldoBruto).sum();
    }

    public double totalRetenciones(){
        return empleados.stream().mapToDouble(Empleado::retenciones).sum();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void liquidarSueldos(){
        for (Empleado empleado : empleados) {
            Recibo recibo = new Recibo(empleado.nombre, empleado.direccion, LocalDate.now(), empleado.sueldoBruto(), empleado.sueldoNeto());
            recibos.add(recibo);
        }
    }

    public List<Recibo> getRecibos() {
        return recibos;
    }
}