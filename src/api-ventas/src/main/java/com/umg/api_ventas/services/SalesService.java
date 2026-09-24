package com.umg.api_ventas.services;

import com.umg.api_ventas.dto.VendedorVentasResponse;
import com.umg.api_ventas.models.Venta;
import com.umg.api_ventas.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private final VentaRepository ventaRepository;

    @Autowired
    public SalesService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<VendedorVentasResponse> obtenerVentasPorVendedor(String vendedorId) {
        List<Venta> ventas = ventaRepository.findByVendedorUsuarioId(vendedorId);
        List<VendedorVentasResponse> respuesta = new ArrayList<>();

        for (Venta venta : ventas) {
            VendedorVentasResponse dto = new VendedorVentasResponse(
                    venta.getVentaId(),
                    venta.getCliente().getNombre(),
                    venta.getFecha(),
                    venta.getTotal(),
                    venta.getEstado().name()
            );
            respuesta.add(dto);
        }

        return respuesta;
    }
}