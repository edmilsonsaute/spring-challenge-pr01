package com.challenge.application01.features.genero;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroRequestDTO {
    @NotNull(message = "Nome é obrigatorio.")
    @NotBlank(message = "Nome é obrigatorio.")
    private String nome;

    
}
