package com.zup.desafioSistemaECommerce.dtos;

import java.util.List;

public class CompraDTO {
    private String cpf;
    private String nomeCliente;
    private List<ProdutoCompraDTO> produto;

    public CompraDTO(String cpf, String nomeCliente, List<ProdutoCompraDTO> produto) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.produto = produto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
