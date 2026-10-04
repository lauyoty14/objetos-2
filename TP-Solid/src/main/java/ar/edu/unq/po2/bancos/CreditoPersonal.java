package ar.edu.unq.po2.bancos;

public class CreditoPersonal extends SolicitudCredito {
    public CreditoPersonal (Cliente cliente, double monto, int plazo){
        super(monto, plazo, cliente);
    }
    
    @Override
    public boolean chequeo () {
        return this.cliente().sueldoNetoAnual() >= 15000 &&
            this.montoCoutaMensual() < (this.cliente().sueldoNetoMensual() * 0.7);
    } 
}