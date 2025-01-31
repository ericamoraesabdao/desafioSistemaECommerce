package com.zup.desafioSistemaECommerce.Services;

import com.zup.desafioSistemaECommerce.dtos.ProdutoDTO;
import com.zup.desafioSistemaECommerce.models.Produto;
import com.zup.desafioSistemaECommerce.repositories.ProdutoRepository;
import com.zup.desafioSistemaECommerce.validations.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO cadastrarProduto(@Valid Produto produto) {
        if (produtoRepository.existsByNome(produto.getNome())) {
            throw new IllegalArgumentException("Já existe um produto com este nome");
        }

        produtoRepository.save(produto);

        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade()))
                .collect(Collectors.toList());
    }

    public boolean produtoExiste(Long id) {

        return produtoRepository.existsById(id);
    }

    public void excluirProduto(Long id) {
        if (produtoExiste(id)) {
            produtoRepository.deleteById(id);
        } else {
            Produto existeProduto = produtoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("O produto não foi deletado pois o ID: " + id + " não foi encontrado."));
        }
    }
}
