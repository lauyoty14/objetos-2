package ar.edu.unq.po2.bancos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditoPersonalTest {
    private Cliente clienteApto; 
    private Cliente clienteIngresosBajos; 
    
    @BeforeEach public void setUp() { 
        clienteApto = new Cliente("Ana", "perez", "Calle 1", 30, 2000.0);
        clienteIngresosBajos = new Cliente("Pedro", "lopez", "Calle 2", 40, 1000.0);   
    }

    @Test
    public void testCreditoPersonalAprobado (){
        SolicitudCredito solicitud = new CreditoPersonal(clienteApto, 12000.0, 12);
        assertTrue(solicitud.chequeo());
    }

    @Test public void testCreditoPersonalRechazadoPorIngresosAnuales() { 
        SolicitudCredito solicitud = new 
            CreditoPersonal(clienteIngresosBajos, 5000.0, 12); 
        assertFalse(solicitud.chequeo()); 
    }
}