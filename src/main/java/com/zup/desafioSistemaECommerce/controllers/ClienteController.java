package com.zup.desafioSistemaECommerce.controllers;

import com.zup.desafioSistemaECommerce.Services.ClienteService;
import com.zup.desafioSistemaECommerce.dtos.ClienteDTO;
import com.zup.desafioSistemaECommerce.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        try {
            ClienteDTO novoCliente = clienteService.cadastrarCliente(cliente);
            return ResponseEntity.ok(novoCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> ClientePorCPF(@Valid @PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.ClientePorCPF(cpf));
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> atualizaCliente(@PathVariable String cpf, @Valid @RequestBody Cliente atualizaCliente) {
        return ResponseEntity.ok(clienteService.atualizaCliente(cpf, atualizaCliente));
    }

}