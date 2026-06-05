package com.urbanshop.catalogo.service;

import com.urbanshop.catalogo.model.Producto;
import com.urbanshop.catalogo.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> buscarConStockDisponible() {
        return productoRepository.findByStockGreaterThan(0);
    }

    // Metodo nuevo para restar stock cuando se realice una venta
    public Producto descontarStock(Long id, Integer cantidadComprada) {
        // Buscar el producto
        Producto producto = findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Verificamos que haya stock
        if (producto.getStock() < cantidadComprada) {
            throw new RuntimeException("Stock insuficiente para realizar la venta");
        }

        // Restamos el stock y guardamos
        producto.setStock(producto.getStock() - cantidadComprada);
        return save(producto);
    }
}