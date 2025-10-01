package com.example.miniCRM.dtos;

import com.example.miniCRM.entity.Contato;
import com.example.miniCRM.enumeration.TipoContato;

public record ContatoResponseDTO(
        Long id,
        TipoContato type,
        String valueType
) {
    public ContatoResponseDTO (Contato contato) {
        this(contato.getId(), contato.getType(), contato.getValueType());
    }
}
