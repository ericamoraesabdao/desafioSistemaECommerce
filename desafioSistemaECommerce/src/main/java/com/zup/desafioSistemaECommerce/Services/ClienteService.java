package com.zup.desafioSistemaECommerce.Services;

import com.zup.desafioSistemaECommerce.dtos.ClienteDTO;
import com.zup.desafioSistemaECommerce.models.Cliente;
import com.zup.desafioSistemaECommerce.repositories.ClienteRepository;
import com.zup.desafioSistemaECommerce.validations.CPFValidator;
import com.zup.desafioSistemaECommerce.validations.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO cadastrarCliente(@Valid Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Já existe um cliente com este email");
        }

        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF");
        }

        if (!CPFValidator.isValidCPF(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }

        clienteRepository.save(cliente);

        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf()))
                .collect(Collectors.toList());
    }

    public ClienteDTO ClientePorCPF(String cpf) {
        Cliente cliente = (Cliente) clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }

    public ClienteDTO atualizaCliente(String cpf, Cliente atualizaCliente) {
        Cliente existeCliente = (Cliente) clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar pois o cliente não foi encontrado."));

        existeCliente.setNome(atualizaCliente.getNome());
        existeCliente.setEmail(atualizaCliente.getEmail());
        existeCliente.setCpf(atualizaCliente.getCpf());

        Cliente salvaCliente = clienteRepository.save(existeCliente);

        return new ClienteDTO(salvaCliente.getId(), salvaCliente.getNome(), salvaCliente.getEmail(), salvaCliente.getCpf());
    }
}
