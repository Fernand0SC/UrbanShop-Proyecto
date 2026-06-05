package com.example.urban.pagos.ordenclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "urban-ordeness", url = "http://localhost:8081")
public interface OrdenCliente {

    @PutMapping("/api/v1/ordenes/{id}/estado")
    void actualizarEstadoOrden(@PathVariable("id") Long id, @RequestParam("estado") String estado);
}