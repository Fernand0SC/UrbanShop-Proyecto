package com.urbanshop.catalogo.repository;

import com.urbanshop.catalogo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Busca productos que contengan una palabra en su nombre
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Busca productos que tengan un stock mayor al número indicado
    List<Producto> findByStockGreaterThan(Integer stock);
}