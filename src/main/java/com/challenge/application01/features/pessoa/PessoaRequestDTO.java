package com.challenge.application01.features.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PessoaRequestDTO {

    @NotBlank(message = "Nome é obrigatorio.")
    private String nome;

    @NotBlank(message =  "Apelido é obrigatorio.")
    private String apelido;

    @NotNull(message =  "Idade é obrigatorio.")
    private byte idade;

    @NotNull(message =  "Genero é obrigatorio.")
    private long genero_id;

    @NotNull(message =  "Endereço é obrigatorio.")
    private long endereco_id;
    
    @NotBlank(message =  "Password é obrigatorio.")
    private String password;
}
