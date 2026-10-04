package ar.edu.unq.po2.bancos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<SolicitudCredito> solicitudes;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){ 
        this.clientes.add(cliente);        
    }

    public void agregarSolicitud (SolicitudCredito solicitud){
        this.solicitudes.add(solicitud);
    }

    public Double montoTotalDesembolsar() {
        return this.solicitudes.stream()
                .filter(SolicitudCredito :: chequeo)
                .mapToDouble(SolicitudCredito::monto)
                .sum();
    }
}