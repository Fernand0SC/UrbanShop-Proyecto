package com.urbanshop.cliente.client;

import com.urbanshop.cliente.dto.WishlistDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// se usa el puerto 8083 que definio Manuel para su wishlist
@FeignClient(name = "wishlist-service", url = "http://localhost:8083")
public interface WishlistClient {
    @GetMapping("/api/v1/wishlist/{usuarioId}")
    List<WishlistDTO> obtenerWishlistDelUsuario(@PathVariable("usuarioId") Long usuarioId);
}
