package com.example.urban.pagos.controller;

import com.example.urban.pagos.modelo.Pagos;
import com.example.urban.pagos.ordenclient.OrdenCliente;
import com.example.urban.pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private OrdenCliente ordenCliente;

    @Autowired
    private PagoRepository pagoRepository;

    @PostMapping
    public ResponseEntity<Pagos> registrarPago(@RequestBody Pagos pago) {

        pago.setEstadoPago("Procesado");

        try {
            ordenCliente.actualizarEstadoOrden(pago.getOrdenId(), "Completado");
        } catch (Exception e) {
            System.out.println("Error de comunicación por Feign: " + e.getMessage());
        }

        Pagos pagoGuardado = pagoRepository.save(pago);
        return new ResponseEntity<>(pagoGuardado, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<java.util.List<Pagos>> obtenerTodosLosPagos() {
        java.util.List<Pagos> listaPagos = pagoRepository.findAll();
        return new ResponseEntity<>(listaPagos, HttpStatus.OK);
    }
}