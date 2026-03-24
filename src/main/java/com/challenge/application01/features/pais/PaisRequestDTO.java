package com.challenge.application01.features.pais;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisRequestDTO {
    
    @NotBlank(message = "Nome é obrigatorio.")
    private String nome;

    private String sigla;
}
