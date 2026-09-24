package com.umg.api_ventas.controllers;

import com.umg.api_ventas.dto.VendedorVentasResponse;
import com.umg.api_ventas.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@CrossOrigin(origins = "*")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/rep/{vendedorId}")
    public ResponseEntity<List<VendedorVentasResponse>> obtenerVentasPorVendedor(@PathVariable String vendedorId) {
        List<VendedorVentasResponse> ventas = salesService.obtenerVentasPorVendedor(vendedorId);
        return ResponseEntity.ok(ventas);
    }
}