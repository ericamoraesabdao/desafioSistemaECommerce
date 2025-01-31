package com.zup.desafioSistemaECommerce.controllers;

import com.zup.desafioSistemaECommerce.Services.CompraService;
import com.zup.desafioSistemaECommerce.dtos.ClienteDTO;
import com.zup.desafioSistemaECommerce.dtos.CompraDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<?> realizarCompra(@Valid @RequestBody CompraDTO compraDTO) {
        try {
            CompraDTO novaCompra = compraService.realizarCompra(compraDTO);
            return ResponseEntity.ok(novaCompra);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}