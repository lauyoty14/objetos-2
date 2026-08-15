import java.time.LocalDate;

public class script {
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa("Edesur", "30-12345678-9");
        Empleado p1 = new EmpleadoPerm(
            "Juan Perez",
            50000.0,
            LocalDate.of(1990, 5, 12),
            "Calle Falsa 123",
            true,
            2,
            10
        );

        Empleado t1 = new EmpleadoTemp(
            "Ana Lopez",
            40000.0,
            LocalDate.of(1995, 8, 21),
            "Av. Siempre Viva 456",
            false,
            LocalDate.of(2026, 12, 31),
            5
        );

        Empleado c1 = new EmpleadoPerm(
            "Carlos Gomez",
            60000.0,
            LocalDate.of(1985, 3, 15),
            "Calle Verdadera 789",
            true,
            1,
            15
        );

        miEmpresa.agregarEmpleado(p1);
        miEmpresa.agregarEmpleado(t1);
        miEmpresa.agregarEmpleado(c1);

        // SCRIPT I: Cálculo de totales
        System.out.println("--- Reporte de Gastos ---");
        System.out.println("Total Sueldos Brutos: $" + miEmpresa.totalSueldoBruto());
        System.out.println("Total Retenciones: $" + miEmpresa.totalRetenciones());
        System.out.println("Monto total a desembolsar (Neto): $" + miEmpresa.totalSueldoNeto());

        // SCRIPT II: Proceso de Liquidación
        System.out.println("--- Iniciando Liquidación de Haberes ---");
        miEmpresa.liquidarSueldos();
        System.out.println("Recibos generados: " + miEmpresa.getRecibos().size());

        for (Recibo r : miEmpresa.getRecibos()) {
            System.out.println("Recibo para: " + r.getNombreEmpleado() + " | Neto: $" + r.getSueldoNeto());
        }
    }
}

