package com.challenge.application01.features.provincia;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinciaRequestDTO {
    @NotNull(message = "Nome é obrigatorio")
    private String nome;

    @NotNull(message = "País é obrigatorio")
    private Long pais_id;
}
