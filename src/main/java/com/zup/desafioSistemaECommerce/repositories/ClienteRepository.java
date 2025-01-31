package com.zup.desafioSistemaECommerce.repositories;

import com.zup.desafioSistemaECommerce.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Optional<Object> findByCpf(String cpf);
}
