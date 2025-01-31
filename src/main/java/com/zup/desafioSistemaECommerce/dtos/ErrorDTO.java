package com.zup.desafioSistemaECommerce.dtos;

public class ErrorDTO {
    String erro;

    public ErrorDTO(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
