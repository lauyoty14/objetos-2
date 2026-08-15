import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoContra extends Empleado {
    protected int numeroContrato;
    protected String medioPago;

    public EmpleadoContra(String nombre, double sueldo, LocalDate fechaNac, String dir, Boolean tieneConyuge, int numeroContrato, String medioPago) {
        super(nombre, sueldo, fechaNac, dir, tieneConyuge);
        this.numeroContrato = numeroContrato;
        this.medioPago = medioPago;
    }

    @Override
    public double sueldoBruto() {
        return sueldoBasico;
    }

    @Override
    public double sueldoNeto() {
        return sueldoBruto() - retenciones();
    }

    @Override
    public double retenciones() {
        return 50;
    }

    @Override
    public ArrayList<String> desgloce() {
        ArrayList<String> desgloce = new ArrayList<>();
        desgloce.add("Sueldo Básico: " + sueldoBasico);
        desgloce.add("Sueldo Bruto: " + sueldoBruto());
        desgloce.add("Retenciones: " + retenciones());
        desgloce.add("Sueldo Neto: " + sueldoNeto());
        return desgloce;
    }
}
