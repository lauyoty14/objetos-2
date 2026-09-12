import java.util.List;

public class Trabajador {
    private double ingresosAnuales;
    private List<Ingreso> ingresos;

    public Trabajador(double ingresosAnuales, List<Ingreso> ingresos) {
        this.ingresosAnuales = ingresosAnuales;
        this.ingresos = ingresos;
    }

    public double getTotalPercibido() {
        double total = 0;

        for (Ingreso ingreso : ingresos) {
            total += ingreso.getMontoPercibido();
        }
        
        return total;
    }

    public double getMontoImponible(){
        double total = 0;

        for (Ingreso ingreso : ingresos) {
            total += ingreso.getMontoImponible();
        }
        
        return total;
    }
    
    public double getImpuestoAPagar() {
        return getMontoImponible() * 0.02;
    }
}
