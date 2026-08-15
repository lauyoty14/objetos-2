import java.util.ArrayList;
import java.time.LocalDate;

public class EmpleadoPerm extends Empleado {
    private int cantHijos;
    private int antiguedad;

    public EmpleadoPerm(String nombre, double sueldoBasico, LocalDate fechaNacimiento, 
        String direccion, Boolean tieneConyuge, int cantHijos, int antiguedad) {
        super(nombre, sueldoBasico, fechaNacimiento, direccion, tieneConyuge);
        this.cantHijos = cantHijos;
        this.antiguedad = antiguedad;
    }

    @Override
    public double sueldoBruto() {
        return sueldoBasico + (cantHijos * 150) + (antiguedad * 50) + 
            (tieneConyuge ? 100 : 0); 
    }

    @Override
    public double retenciones() {
        return (sueldoBruto() * 0.10) + (cantHijos * 20) + (sueldoBruto() * 0.15); 
    }

    @Override
    public ArrayList<String> desgloce() {
        ArrayList<String> desgloce = new ArrayList<>();
        desgloce.add("Sueldo Básico: " + sueldoBasico);
        desgloce.add("Asignación por Hijos: " + (cantHijos * 150));
        desgloce.add("Asignación por Antigüedad: " + (antiguedad * 50));
        desgloce.add("Asignación por Conyuge: " + (tieneConyuge ? 100 : 0));
        desgloce.add("Sueldo Bruto: " + sueldoBruto());
        desgloce.add("Obra social: " + (sueldoBruto() * 0.10 + cantHijos * 20));
        desgloce.add("Aportes jubilatorios: " + sueldoBruto() * 0.15);
        desgloce.add("Retenciones: " + retenciones());
        return desgloce;
    }
}