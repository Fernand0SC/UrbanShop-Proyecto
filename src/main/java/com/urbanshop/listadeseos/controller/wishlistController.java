package com.urbanshop.listadeseos.controller;
import com.urbanshop.listadeseos.dto.WIshlistRequestDTO; // Tu nuevo DTO
import com.urbanshop.listadeseos.model.Wishlist;
import com.urbanshop.listadeseos.service.WishlistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class wishlistController { // Nombre de clase en PascalCase (buena práctica)

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Wishlist> agregar(@Valid @RequestBody WIshlistRequestDTO dto) {
        Wishlist item = new Wishlist();
        item.setUsuarioId(dto.getUsuarioId());
        item.setProductoId(dto.getProductoId());

        Wishlist creado = wishlistService.agregarProducto(item);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201 Created
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Wishlist>> listar(@PathVariable Long usuarioId) {
        List<Wishlist> lista = wishlistService.obtenerPorUsuario(usuarioId);
        return ResponseEntity.ok(lista); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        wishlistService.eliminarProducto(id);
        return ResponseEntity.noContent().build(); // 204 No Content (lo estándar para eliminar)
    }

    @GetMapping("/test")
    public ResponseEntity<String> prueba() {
        return ResponseEntity.ok("Conectado");
    }
}