package com.umg.api_ventas.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(name = "producto_id", length = 50)
    private String productoId;

    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "meses_garantia")
    private Integer mesesGarantia;

    @Column(nullable = false)
    private Integer stock;

    public Producto() {
    }

    public Producto(String productoId, String sku, String nombre, BigDecimal precio, Integer mesesGarantia, Integer stock) {
        this.productoId = productoId;
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.mesesGarantia = mesesGarantia;
        this.stock = stock;
    }

    public String getProductoId() { 
        return productoId; 
    }
    public void setProductoId(String productoId) { 
        this.productoId = productoId; 
    }

    public String getSku() { 
        return sku; 
    }
    public void setSku(String sku) { 
        this.sku = sku; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public BigDecimal getPrecio() { 
        return precio; 
    }
    public void setPrecio(BigDecimal precio) { 
        this.precio = precio; 
    }

    public Integer getMesesGarantia() { 
        return mesesGarantia; 
    }
    public void setMesesGarantia(Integer mesesGarantia) { 
        this.mesesGarantia = mesesGarantia; 
    }

    public Integer getStock() { 
        return stock; 
    }
    public void setStock(Integer stock) { 
        this.stock = stock; 
    }
}