package com.zup.desafioSistemaECommerce.validations;

import java.util.List;

public class ProdutosEmFaltaException extends RuntimeException {

    private final List<String> produtosEmFalta;

    public ProdutosEmFaltaException(List<String> produtosEmFalta) {
        super("Produtos em falta: " + String.join(", ", produtosEmFalta));
        this.produtosEmFalta = produtosEmFalta;
    }

    public List<String> getProdutosEmFalta() {
        return produtosEmFalta;
    }
}
