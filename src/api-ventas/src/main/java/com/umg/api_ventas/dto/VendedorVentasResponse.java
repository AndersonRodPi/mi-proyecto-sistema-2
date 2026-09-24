package com.umg.api_ventas.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendedorVentasResponse {
    private String ventaId;
    private String clienteNombre;
    private LocalDateTime fecha;
    private BigDecimal total;
    private String estado;

    public VendedorVentasResponse() {}

    public VendedorVentasResponse(String ventaId, String clienteNombre, LocalDateTime fecha, BigDecimal total, String estado) {
        this.ventaId = ventaId;
        this.clienteNombre = clienteNombre;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public String getVentaId() { 
        return ventaId; 
    }
    public void setVentaId(String ventaId) { 
        this.ventaId = ventaId; 
    }

    public String getClienteNombre() { 
        return clienteNombre; 
    }
    public void setClienteNombre(String clienteNombre) { 
        this.clienteNombre = clienteNombre; 
    }

    public LocalDateTime getFecha() { 
        return fecha; 
    }
    public void setFecha(LocalDateTime fecha) { 
        this.fecha = fecha; 
    }

    public BigDecimal getTotal() { 
        return total; 
    }
    public void setTotal(BigDecimal total) { 
        this.total = total; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
}