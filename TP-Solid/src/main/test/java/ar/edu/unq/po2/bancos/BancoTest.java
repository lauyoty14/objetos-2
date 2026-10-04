package ar.edu.unq.po2.bancos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BancoTest {

	@Test
	public void montoTotalDesembolsarSumaSoloSolicitudesAprobadas() {
		Banco banco = new Banco();
		Cliente clienteApto = new Cliente("Ana", "Perez", "Calle 1", 30, 2000.0);
		Cliente clienteIngresosBajos = new Cliente("Pedro", "Lopez", "Calle 2", 40, 1000.0);

		banco.agregarSolicitud(new CreditoPersonal(clienteApto, 12000.0, 12));
		banco.agregarSolicitud(new CreditoPersonal(clienteIngresosBajos, 5000.0, 12));

		assertEquals(12000.0, banco.montoTotalDesembolsar(), 0.001);
	}

	@Test
	public void montoTotalDesembolsarEsCeroCuandoNoHaySolicitudes() {
		Banco banco = new Banco();

		assertEquals(0.0, banco.montoTotalDesembolsar(), 0.001);
	}
}
