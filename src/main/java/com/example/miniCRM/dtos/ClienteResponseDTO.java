package com.example.miniCRM.dtos;

import com.example.miniCRM.entity.Cliente;
import com.example.miniCRM.entity.Contato;

import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String name,
        String email,
        List<Contato> contacts
) {
    public ClienteResponseDTO (Cliente cliente) {
        this(cliente.getId(), cliente.getName(), cliente.getEmail(), cliente.getContacts());
    }
}
