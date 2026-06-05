package com.example.urban.ordeness.service;

import com.example.urban.ordeness.cliente.PagoCliente;
import com.example.urban.ordeness.dto.OrdenesRequestDTO;
import com.example.urban.ordeness.modelo.Ordenes;
import com.example.urban.ordeness.repository.OrdenesRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Slf4j
@Service
public class OrdenesService {

    @Autowired
    private OrdenesRepository ordenesRepository;

    @Autowired
    private PagoCliente pagoCliente;


    public Ordenes crearOrden(OrdenesRequestDTO dto) {
        log.info("Iniciando creación de orden para cliente: {}", dto.getCliente());

        Ordenes ordenes = new Ordenes();
        ordenes.setCliente(dto.getCliente());
        ordenes.setTotal(dto.getTotal());
        ordenes.setEstado("PENDIENTE");

        Ordenes guardada = ordenesRepository.save(ordenes);
        log.info("Orden creada exitosamente con ID: {}", guardada.getId());
        return guardada;
    }


    public Ordenes pagarOrden(Long ordenId) {
        log.info("Iniciando proceso de pago para la orden ID: {}", ordenId);

        Ordenes ordenes = ordenesRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        try {
            Map<String, Object> requestPago = Map.of(
                    "ordenId", ordenes.getId(),
                    "monto", ordenes.getTotal()
            );

            Map<String, Object> respuesta = pagoCliente.procesarPago(requestPago);

            if ("APROBADO".equals(respuesta.get("estado"))) {
                ordenes.setEstado("PAGADA");
                log.info("Pago aprobado para la orden ID: {}", ordenId);
            } else {
                ordenes.setEstado("RECHAZADA");
                log.warn("Pago rechazado para la orden ID: {}", ordenId);
            }
        } catch (Exception e) {
            log.error("Error al comunicar con la pasarela de pagos: {}", e.getMessage());
            ordenes.setEstado("ERROR_PASARELA");
        }

        return ordenesRepository.save(ordenes);
    }
}