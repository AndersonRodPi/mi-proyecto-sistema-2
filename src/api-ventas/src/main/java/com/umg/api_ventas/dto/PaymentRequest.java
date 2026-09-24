package com.umg.api_ventas.dto;
import java.math.BigDecimal;

public class PaymentRequest {
    private String ventaId;
    private String metodoPago;
    private BigDecimal monto;

    public PaymentRequest() {}

    public String getVentaId() { 
        return ventaId; 
    }
    public void setVentaId(String ventaId) { 
        this.ventaId = ventaId; 
    }

    public String getMetodoPago() { 
        return metodoPago; 
    }
    public void setMetodoPago(String metodoPago) { 
        this.metodoPago = metodoPago; 
    }

    public BigDecimal getMonto() { 
        return monto; 
    }
    public void setMonto(BigDecimal monto) { 
        this.monto = monto; 
    }
}