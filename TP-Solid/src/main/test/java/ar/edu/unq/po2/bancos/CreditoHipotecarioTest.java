package ar.edu.unq.po2.bancos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditoHipotecarioTest {

	@Test
	public void chequeoApruebaSolicitudCuandoCumpleLosTresCriterios() {
		Cliente cliente = new Cliente("Ana", "Perez", "Calle 1", 45, 4000.0);
		PropiedadInmobiliaria propiedad = new PropiedadInmobiliaria("Casa", "Calle 3", 200000.0);
		CreditoHipotecario credito = new CreditoHipotecario(cliente, 120000.0, 240, propiedad);

		assertTrue(credito.chequeo());
	}

	@Test
	public void chequeoRechazaSolicitudCuandoLaCuotaSuperaLaMitadDelSueldo() {
		Cliente cliente = new Cliente("Pedro", "Lopez", "Calle 2", 40, 1000.0);
		PropiedadInmobiliaria propiedad = new PropiedadInmobiliaria("Casa", "Calle 3", 500000.0);
		CreditoHipotecario credito = new CreditoHipotecario(cliente, 200000.0, 240, propiedad);

		assertFalse(credito.chequeo());
	}

	@Test
	public void chequeoRechazaSolicitudCuandoMontoSuperaEl70PorCientoDelValorFiscal() {
		Cliente cliente = new Cliente("Ana", "Perez", "Calle 1", 40, 4000.0);
		PropiedadInmobiliaria propiedad = new PropiedadInmobiliaria("Casa", "Calle 3", 200000.0);
		CreditoHipotecario credito = new CreditoHipotecario(cliente, 140001.0, 240, propiedad);

		assertFalse(credito.chequeo());
	}

	@Test
	public void chequeoRechazaSolicitudCuandoLaEdadAlFinalizarSupera65() {
		Cliente cliente = new Cliente("Ana", "Perez", "Calle 1", 46, 4000.0);
		PropiedadInmobiliaria propiedad = new PropiedadInmobiliaria("Casa", "Calle 3", 200000.0);
		CreditoHipotecario credito = new CreditoHipotecario(cliente, 120000.0, 240, propiedad);

		assertFalse(credito.chequeo());
	}
}
