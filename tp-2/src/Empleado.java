import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
    // Atributos (se declaran con su tipo)
    protected String nombre;
    protected double sueldoBasico; // Usamos double para representar el "Real" del UML
    protected LocalDate fechaNacimiento; // Para manejar fechas
    protected String direccion;
    protected Boolean tieneConyuge;

    // Constructor: sirve para crear al empleado con sus datos iniciales
    public Empleado(String nombre, double sueldoBasico, LocalDate fechaNacimiento, 
        String direccion, Boolean tieneConyuge) {
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.tieneConyuge = tieneConyuge;
    }

    public int edad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears(); // Calcula la edad del empleado
    }

    public abstract ArrayList<String> desgloce(); // Método abstracto: cada tipo de empleado lo implementa a su manera

    public abstract double sueldoBruto(); // Método abstracto: cada tipo de empleado lo implementa a su manera

    public abstract double retenciones(); // Método abstracto: cada tipo de empleado lo implementa a su manera

    public double sueldoNeto() {
        return sueldoBruto() - retenciones(); // Calcula el sueldo neto restando las retenciones al sueldo bruto
    }
}