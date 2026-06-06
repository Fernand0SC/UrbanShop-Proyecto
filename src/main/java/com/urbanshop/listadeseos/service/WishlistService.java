package com.urbanshop.listadeseos.service;

import com.urbanshop.listadeseos.client.CatalogoClient;
import com.urbanshop.listadeseos.model.Wishlist;
import com.urbanshop.listadeseos.repository.WishlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {

    private static final Logger log = LoggerFactory.getLogger(WishlistService.class);

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private CatalogoClient catalogoClient;

    public Wishlist agregarProducto(Wishlist item) {
        log.info("Iniciando validación de producto ID: {} para la wishlist del usuario: {}",
                item.getProductoId(), item.getUsuarioId());

        try {
            catalogoClient.obtenerProducto(item.getProductoId());
            log.info("Producto validado correctamente en el catálogo.");
        } catch (Exception e) {
            log.error("Error al validar el producto ID: {}. El catálogo no respondió.", item.getProductoId());
            throw new RuntimeException("El producto con ID " + item.getProductoId() + " no existe o el catálogo no está disponible.");
        }

        Wishlist savedItem = wishlistRepository.save(item);
        log.info("Producto guardado exitosamente en wishlist con ID: {}", savedItem.getId());
        return savedItem;
    }

    public List<Wishlist> obtenerPorUsuario(Long usuarioId) {
        log.info("Consultando wishlist para el usuario: {}", usuarioId);
        return wishlistRepository.findByUsuarioId(usuarioId);
    }

    public void eliminarProducto(Long id) {
        log.warn("Eliminando producto de la wishlist con ID: {}", id);
        wishlistRepository.deleteById(id);
    }
}