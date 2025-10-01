package com.example.miniCRM.dtos;

import com.example.miniCRM.enumeration.TipoContato;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

public record ContatoRequestDTO(
        @NotBlank
        TipoContato type,
        @NotBlank
        String valueType
        ) {
}
