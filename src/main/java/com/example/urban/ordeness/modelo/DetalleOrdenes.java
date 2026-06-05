package com.example.urban.ordeness.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalles_ordenes")
public class DetalleOrdenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private Integer cantidad;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "ordenes_id")
    private Ordenes ordenes;
}