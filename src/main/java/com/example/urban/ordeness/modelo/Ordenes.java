package com.example.urban.ordeness.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private Double total;
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenes")
    private List<DetalleOrdenes> detalles;
}