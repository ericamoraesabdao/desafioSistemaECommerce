package com.zup.desafioSistemaECommerce.controllers;

import com.zup.desafioSistemaECommerce.Services.ProdutoService;
import com.zup.desafioSistemaECommerce.dtos.ProdutoDTO;
import com.zup.desafioSistemaECommerce.models.Produto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@Valid @RequestBody Produto produto) {
        try {
            ProdutoDTO novoProduto = produtoService.cadastrarProduto(produto);
            return ResponseEntity.ok(novoProduto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
