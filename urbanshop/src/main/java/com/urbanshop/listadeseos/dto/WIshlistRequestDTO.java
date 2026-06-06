package com.urbanshop.listadeseos.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class WIshlistRequestDTO {
    @NotNull(message = "El usuarioId no puede ser nulo")
    private Long usuarioId;

    @NotNull(message = "El productoId no puede ser nulo")
    private Long productoId;


}
