import java.util.ArrayList;
import java.time.LocalDate;

public class Recibo {
    private String nombreEmpleado;
    private String direccion;
    private LocalDate fecEmision;
    private double sueldoBruto;
    private double sueldoNeto;

    public Recibo(String nombreEmpleado, String direccion, LocalDate fecEmision, 
        double sueldoBruto, double sueldoNeto) {
        this.nombreEmpleado = nombreEmpleado;
        this.direccion = direccion;
        this.fecEmision = fecEmision;
        this.sueldoBruto = sueldoBruto;
        this.sueldoNeto = sueldoNeto;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public ArrayList<String> desgloce(Empleado empleado){
        return empleado.desgloce();
    }
}