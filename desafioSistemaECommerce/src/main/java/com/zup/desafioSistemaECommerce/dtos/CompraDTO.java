package com.zup.desafioSistemaECommerce.dtos;

import java.util.List;

public class CompraDTO {
    private String cpf;
    private List<ProdutoCompraDTO> produto;

    public CompraDTO(String cpf, List<ProdutoCompraDTO> produto) {
        this.cpf = cpf;
        this.produto = produto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProdutoCompraDTO> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoCompraDTO> produto) {
        this.produto = produto;
    }
}
