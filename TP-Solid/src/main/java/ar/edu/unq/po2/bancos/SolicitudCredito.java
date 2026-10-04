package ar.edu.unq.po2.bancos;

public abstract class SolicitudCredito {
    private double montoSolicitado;
    private int plazo;
    private Cliente cliente;

    public SolicitudCredito(double monto, int plazo, Cliente cliente) {
        this.montoSolicitado = monto;
        this.plazo = plazo;
        this.cliente = cliente;
    }

    public double monto() {
        return this.montoSolicitado;
    }

    public int plazo() {
        return this.plazo;
    }

    public Cliente cliente() {
        return this.cliente;
    }

    public double montoCoutaMensual () {
        return this.montoSolicitado / this.plazo;
    }

    public abstract boolean chequeo();
}