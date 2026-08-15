import java.util.ArrayList;
import java.time.LocalDate;

public class EmpleadoTemp extends Empleado {
    protected LocalDate fecFinDesignacion;
    protected int cantHorasExtra;

    public EmpleadoTemp(String nombre, double sueldoBasico, LocalDate fechaNacimiento, 
        String direccion, Boolean tieneConyuge, LocalDate fecFinDesignacion, int cantHorasExtra) {
        super(nombre, sueldoBasico, fechaNacimiento, direccion, tieneConyuge);
        this.fecFinDesignacion = fecFinDesignacion;
        this.cantHorasExtra = cantHorasExtra;
    }

    @Override
    public double sueldoBruto() {
        return sueldoBasico + (cantHorasExtra * 40);
    }

    @Override
    public double retenciones() {
        return sueldoBruto() * 0.10 + (edad() > 50 ? 25 : 0) + sueldoBruto() * 0.10 
            + (cantHorasExtra * 5);
    }

    @Override
    public ArrayList<String> desgloce() {
        ArrayList<String> desgloce = new ArrayList<>();
        desgloce.add("Sueldo Básico: " + sueldoBasico);
        desgloce.add("Horas extra: " + (cantHorasExtra * 40));
        desgloce.add("Sueldo Bruto: " + sueldoBruto());
        desgloce.add("Obra social: " + (sueldoBruto() * 0.10 + (edad() > 50 ? 25 : 0)));
        desgloce.add("Aportes jubilatorios: " + sueldoBruto() * 0.15 + (cantHorasExtra * 5));
        desgloce.add("Retenciones: " + retenciones());
        return desgloce;
    }
}