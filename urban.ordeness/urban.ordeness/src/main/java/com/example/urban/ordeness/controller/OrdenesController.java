package com.example.urban.ordeness.controller;
import org.springframework.transaction.annotation.Transactional;
import com.example.urban.ordeness.dto.OrdenesRequestDTO;
import com.example.urban.ordeness.modelo.Ordenes;
import com.example.urban.ordeness.service.OrdenesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ordenes")
public class OrdenesController {

    @Autowired
    private OrdenesService ordenesService;

    @PostMapping
    public ResponseEntity<Ordenes> registrarOrden(@Valid @RequestBody OrdenesRequestDTO dto) {
        return new ResponseEntity<>(ordenesService.crearOrden(dto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<Ordenes> pagarOrden(@PathVariable Long id) {
        return ResponseEntity.ok(ordenesService.pagarOrden(id));
    }
}