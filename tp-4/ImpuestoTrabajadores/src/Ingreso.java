public class Ingreso {
    private String mesPercepcion;
    private String concepto;
    private double montoPercibido;
    
    public Ingreso(String mesPercepcion, String concepto, double montoPercibido) {
        this.mesPercepcion = mesPercepcion;
        this.concepto = concepto;
        this.montoPercibido = montoPercibido;
    }

    public double getMontoPercibido() {
        return montoPercibido;
    }

    public double getMontoImponible() {
        return montoPercibido;
    }
}
