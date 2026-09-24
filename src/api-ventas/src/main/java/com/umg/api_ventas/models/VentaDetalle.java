
package com.umg.api_ventas.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venta_detalles")
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Integer detalleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    public VentaDetalle() {
    }

    public VentaDetalle(Integer detalleId, Venta venta, Producto producto, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.detalleId = detalleId;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Integer getDetalleId() { 
        return detalleId; 
    }
    public void setDetalleId(Integer detalleId) { 
        this.detalleId = detalleId; 
    }

    public Venta getVenta() { 
        return venta; 
    }
    public void setVenta(Venta venta) { 
        this.venta = venta; 
    }

    public Producto getProducto() { 
        return producto; 
    }
    public void setProducto(Producto producto) { 
        this.producto = producto; 
    }

    public Integer getCantidad() { 
        return cantidad; 
    }
    public void setCantidad(Integer cantidad) { 
        this.cantidad = cantidad; 
    }

    public BigDecimal getPrecioUnitario() { 
        return precioUnitario; 
    }
    public void setPrecioUnitario(BigDecimal precioUnitario) { 
        this.precioUnitario = precioUnitario; 
    }

    public BigDecimal getSubtotal() { 
        return subtotal; 
    }
    public void setSubtotal(BigDecimal subtotal) { 
        this.subtotal = subtotal; 
    }
}