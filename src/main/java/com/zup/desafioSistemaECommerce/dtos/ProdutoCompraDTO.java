package com.zup.desafioSistemaECommerce.dtos;

public class ProdutoCompraDTO {
    private String nome;

    public ProdutoCompraDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
