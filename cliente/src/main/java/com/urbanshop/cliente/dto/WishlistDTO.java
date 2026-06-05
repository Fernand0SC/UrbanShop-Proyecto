package com.urbanshop.cliente.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WishlistDTO {
    private Long id;
    private Long usuarioId;
    private Long productoId;
    private LocalDateTime createdAt;
}