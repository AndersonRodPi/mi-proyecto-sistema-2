package com.umg.api_ventas.services;

import com.umg.api_ventas.dto.PaymentRequest;
import com.umg.api_ventas.dto.PaymentResponse;
import com.umg.api_ventas.models.Pago;
import com.umg.api_ventas.models.Venta;
import com.umg.api_ventas.repositories.PagoRepository;
import com.umg.api_ventas.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentService {

    private final PagoRepository pagoRepository;
    private final VentaRepository ventaRepository;

    @Autowired
    public PaymentService(PagoRepository pagoRepository, VentaRepository ventaRepository) {
        this.pagoRepository = pagoRepository;
        this.ventaRepository = ventaRepository;
    }

    @Transactional
    public PaymentResponse procesarPago(PaymentRequest request) {
        // 1. Buscar la venta asociada
        Venta venta = ventaRepository.findById(request.getVentaId())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + request.getVentaId()));

        // 2. Construir el objeto Pago
        Pago pago = new Pago();
        pago.setVenta(venta);
        pago.setMetodoPago(request.getMetodoPago());
        pago.setMonto(request.getMonto());
        pago.setTransaccionPasarela("TX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        pago.setEstadoPago(Pago.EstadoPago.APROBADO);

        // 3. Guardar el pago en la base de datos
        Pago pagoGuardado = pagoRepository.save(pago);

        // 4. Actualizar el estado de la venta a COMPLETADA
        venta.setEstado(Venta.EstadoVenta.COMPLETADA);
        ventaRepository.save(venta);

        return new PaymentResponse(
                true,
                "Pago procesado exitosamente",
                pagoGuardado.getTransaccionPasarela()
        );
    }
}