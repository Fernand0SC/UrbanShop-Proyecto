package com.urbanshop.listadeseos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "wishlist_items")
@Data
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;


    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}