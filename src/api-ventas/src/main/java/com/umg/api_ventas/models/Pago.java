package com.umg.api_ventas.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pago_id")
    private Integer pagoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id", nullable = false, unique = true)
    private Venta venta;

    @Column(name = "transaccion_pasarela", nullable = false, length = 100)
    private String transaccionPasarela;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", nullable = false)
    private EstadoPago estadoPago;

    @Column(name = "fecha_pago", insertable = false, updatable = false)
    private LocalDateTime fechaPago;

    public enum EstadoPago { APROBADO, RECHAZADO, REEMBOLSADO }

    public Pago() {
    }

    public Pago(Integer pagoId, Venta venta, String transaccionPasarela, String metodoPago, BigDecimal monto, EstadoPago estadoPago, LocalDateTime fechaPago) {
        this.pagoId = pagoId;
        this.venta = venta;
        this.transaccionPasarela = transaccionPasarela;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
    }

    public Integer getPagoId() { 
        return pagoId; 
    }
    public void setPagoId(Integer pagoId) { 
        this.pagoId = pagoId; 
    }

    public Venta getVenta() { 
        return venta; 
    }
    public void setVenta(Venta venta) { 
        this.venta = venta; 
    }

    public String getTransaccionPasarela() { 
        return transaccionPasarela; 
    }
    public void setTransaccionPasarela(String transaccionPasarela) { 
        this.transaccionPasarela = transaccionPasarela; 
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

    public EstadoPago getEstadoPago() { 
        return estadoPago; 
    }
    public void setEstadoPago(EstadoPago estadoPago) { 
        this.estadoPago = estadoPago; 
    }

    public LocalDateTime getFechaPago() { 
        return fechaPago; 
    }
    public void setFechaPago(LocalDateTime fechaPago) { 
        this.fechaPago = fechaPago; 
    }
}