package com.example.urban.ordeness.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "pago-service", url = "http://localhost:8082/api/v1/pagos")
public interface PagoCliente {

    @PostMapping
    Map<String, Object> procesarPago(@RequestBody Map<String, Object> requestPago);
}