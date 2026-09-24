package com.umg.api_ventas.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "venta_id", length = 50)
    private String ventaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario vendedor;

    @Column(name = "fecha", insertable = false, updatable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'PENDIENTE'")
    private EstadoVenta estado;

    public enum EstadoVenta { PENDIENTE, COMPLETADA, CANCELADA }

    public Venta() {
    }

    public Venta(String ventaId, Cliente cliente, Usuario vendedor, LocalDateTime fecha, BigDecimal total, EstadoVenta estado) {
        this.ventaId = ventaId;
        this.cliente = cliente;
        this.vendedor = vendedor;
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

    public Cliente getCliente() { 
        return cliente; 
    }
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public Usuario getVendedor() { 
        return vendedor; 
    }
    public void setVendedor(Usuario vendedor) { 
        this.vendedor = vendedor; 
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

    public EstadoVenta getEstado() { 
        return estado; 
    }
    public void setEstado(EstadoVenta estado) { 
        this.estado = estado; 
    }
}