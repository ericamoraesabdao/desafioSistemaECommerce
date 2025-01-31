package com.zup.desafioSistemaECommerce.repositories;

import com.zup.desafioSistemaECommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByNome(String nome);
    Produto findByNome(String nome);

}
