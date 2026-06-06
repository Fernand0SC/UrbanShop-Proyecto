package com.urbanshop.listadeseos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "catalogo", url = "http://localhost:8082")
public interface CatalogoClient {

    @GetMapping("/api/v1/productos/{id}")
    Object obtenerProducto(@PathVariable("id") Long id);
}
