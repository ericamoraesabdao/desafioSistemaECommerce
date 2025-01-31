package com.zup.desafioSistemaECommerce.Services;

import com.zup.desafioSistemaECommerce.dtos.CompraDTO;
import com.zup.desafioSistemaECommerce.dtos.ProdutoCompraDTO;
import com.zup.desafioSistemaECommerce.models.Cliente;
import com.zup.desafioSistemaECommerce.models.Produto;
import com.zup.desafioSistemaECommerce.repositories.ClienteRepository;
import com.zup.desafioSistemaECommerce.repositories.ProdutoRepository;
import com.zup.desafioSistemaECommerce.validations.ProdutosEmFaltaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public CompraDTO realizarCompra(CompraDTO compraDTO) {
        Cliente cliente = (Cliente) clienteRepository.findByCpf(compraDTO.getCpf())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        List<String> produtosEmFalta = new ArrayList<>();

        for (ProdutoCompraDTO produtoDTO : compraDTO.getProduto()) {
            Produto produto = produtoRepository.findByNome(produtoDTO.getNome());
            if (produto == null) {
                throw new IllegalArgumentException("Produto " + produtoDTO.getNome() + " não encontrado.");
            }
            if (produto.getQuantidade() <= 0) {
                produtosEmFalta.add(produtoDTO.getNome());
            }
        }

        if (!produtosEmFalta.isEmpty()) {
            throw new ProdutosEmFaltaException(produtosEmFalta);
        }

        for (ProdutoCompraDTO produtoDTO : compraDTO.getProduto()) {
            Produto produto = produtoRepository.findByNome(produtoDTO.getNome());
            produto.setQuantidade(produto.getQuantidade() - 1);
            produtoRepository.save(produto);
        }

        return new CompraDTO(cliente.getCpf(), cliente.getNome(), compraDTO.getProduto());
    }
}
