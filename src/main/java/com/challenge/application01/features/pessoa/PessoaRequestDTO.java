package com.challenge.application01.features.pessoa;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PessoaRequestDTO {

    @NotBlank(message = "Nome é obrigatorio.")
    private String nome;

    @NotBlank(message =  "Apelido é obrigatorio.")
    private String apelido;

    @NotBlank(message =  "Idade é obrigatorio.")
    private short idade;

    @NotBlank(message =  "Genero é obrigatorio.")
    private long genero_id;

    @NotBlank(message =  "Endereço é obrigatorio.")
    private long endereco_id;
    
}
