package com.example.miniCRM.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        String email
) {
}
