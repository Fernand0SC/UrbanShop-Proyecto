package com.example.urban.ordeness.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrdenesRequestDTO {
    @NotBlank(message = "El nombre del cliente es obligatorio. ")
    private String cliente;

    @NotNull(message = "El total es obligatorio")
    @Positive(message = "El total debe ser mayor a cero")
    private Double total;
}