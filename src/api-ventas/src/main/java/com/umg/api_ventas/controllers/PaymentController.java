package com.umg.api_ventas.controllers;

import com.umg.api_ventas.dto.PaymentRequest;
import com.umg.api_ventas.dto.PaymentResponse;
import com.umg.api_ventas.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> procesarPago(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.procesarPago(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}