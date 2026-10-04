package ar.edu.unq.po2.bancos;

public class Cliente {
    private String nombre;
    private String apellido; 
    private String direccion;
    private int edad;
    private double sueldoNetoMensual;

    public Cliente(String nombre, String apellido, String direccion, int edad, 
                    double sueldoNetoMensual) { 
        this.nombre = nombre; 
        this.apellido = apellido;
        this.direccion = direccion; 
        this.edad = edad; 
        this.sueldoNetoMensual = sueldoNetoMensual; 
    }

    public double sueldoNetoAnual(){
        return this.sueldoNetoMensual * 12 ;
    }

    public double sueldoNetoMensual(){
        return this.sueldoNetoMensual;
    }

    public int edad() {
        return this.edad;
    }

    public void pedirCredito (SolicitudCredito solicitud, Banco banco) {
        banco.agregarSolicitud(solicitud);
    }
}