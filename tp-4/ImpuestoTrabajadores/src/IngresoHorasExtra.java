public class IngresoHorasExtra extends Ingreso {
    private int cantidadHorasExtra;

    public IngresoHorasExtra(String mesPercepcion, String concepto, double montoPercibido, int cantidadHorasExtra) {
        super(mesPercepcion, concepto, montoPercibido);
        this.cantidadHorasExtra = cantidadHorasExtra;
    }

    @Override 
    public double getMontoImponible() {
        return 0;
    }
}
