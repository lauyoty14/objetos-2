import java.util.Arrays;
import java.util.List;

public class IngresosTest {

    public static void main(String[] args) {
        testTotalPercibido();
        testMontoImponible();
        testImpuestoAPagar();
        testHorasExtraNoTributan();
        System.out.println("Todos los tests pasaron.");
    }

    private static void testTotalPercibido() {
        List<Ingreso> ingresos = Arrays.asList(
            new Ingreso("Enero", "Sueldo", 1000),
            new IngresoHorasExtra("Febrero", "Horas Extras", 300, 5),
            new Ingreso("Marzo", "Comision", 500)
        );

        Trabajador trabajador = new Trabajador(0, ingresos);

        assertEquals(1800, trabajador.getTotalPercibido(), "El total percibido debe sumar todos los ingresos.");
    }

    private static void testMontoImponible() {
        List<Ingreso> ingresos = Arrays.asList(
            new Ingreso("Enero", "Sueldo", 1000),
            new IngresoHorasExtra("Febrero", "Horas Extras", 300, 5),
            new Ingreso("Marzo", "Comision", 500)
        );

        Trabajador trabajador = new Trabajador(0, ingresos);

        assertEquals(1500, trabajador.getMontoImponible(), "Las horas extra no deben sumar al monto imponible.");
    }

    private static void testImpuestoAPagar() {
        List<Ingreso> ingresos = Arrays.asList(
            new Ingreso("Enero", "Sueldo", 1000),
            new IngresoHorasExtra("Febrero", "Horas Extras", 300, 5),
            new Ingreso("Marzo", "Comision", 500),
            new Ingreso("Abril", "Sueldo", 200)
        );

        Trabajador trabajador = new Trabajador(0, ingresos);

        assertEquals(34.0, trabajador.getImpuestoAPagar(), "El impuesto es el 2% del monto imponible.");
    }

    private static void testHorasExtraNoTributan() {
        List<Ingreso> ingresos = Arrays.asList(
            new IngresoHorasExtra("Mayo", "Horas Extras", 600, 10),
            new IngresoHorasExtra("Junio", "Horas Extras", 400, 8)
        );

        Trabajador trabajador = new Trabajador(0, ingresos);

        assertEquals(0, trabajador.getMontoImponible(), "El monto imponible debe ser cero si solo hay horas extra.");
        assertEquals(0, trabajador.getImpuestoAPagar(), "El impuesto debe ser cero si no hay ingresos imponibles.");
    }

    private static void assertEquals(double expected, double actual, String message) {
        if (Math.abs(expected - actual) > 0.0001) {
            throw new AssertionError(message + " Esperado: " + expected + ", obtenido: " + actual);
        }
    }
}
