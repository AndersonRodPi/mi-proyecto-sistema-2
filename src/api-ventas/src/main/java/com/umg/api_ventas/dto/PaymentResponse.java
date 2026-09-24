package com.umg.api_ventas.dto;

public class PaymentResponse {
    private boolean exito;
    private String mensaje;
    private String transaccionPasarela;

    public PaymentResponse() {}

    public PaymentResponse(boolean exito, String mensaje, String transaccionPasarela) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.transaccionPasarela = transaccionPasarela;
    }

    public boolean isExito() { 
        return exito; 
    }
    public void setExito(boolean exito) { 
        this.exito = exito; 
    }

    public String getMensaje() { 
        return mensaje; 
    }
    public void setMensaje(String mensaje) { 
        this.mensaje = mensaje; 
    }

    public String getTransaccionPasarela() { 
        return transaccionPasarela; 
    }
    public void setTransaccionPasarela(String transaccionPasarela) { 
        this.transaccionPasarela = transaccionPasarela; 
    }
}