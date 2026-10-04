package ar.edu.unq.po2.bancos;

public class CreditoHipotecario extends SolicitudCredito {
    private PropiedadInmobiliaria propiedad;

    public CreditoHipotecario (Cliente cliente, double monto, int plazo, 
                                PropiedadInmobiliaria propiedad) {
        super(monto, plazo, cliente);
        this.propiedad = propiedad;
    }
    
    @Override
    public boolean chequeo() {
        boolean coutaValida = this.montoCoutaMensual() <= (this.cliente().sueldoNetoMensual() * 0.5);
        boolean montoValido = this.monto() <= (this.propiedad.valorFiscal() * 0.7);
        boolean edadValida = (this.cliente().edad() + (this.plazo() / 12)) <= 65;

        return coutaValida && montoValido && edadValida;
    }
}