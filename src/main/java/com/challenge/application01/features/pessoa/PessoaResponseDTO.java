package com.challenge.application01.features.pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaResponseDTO {

    private long id;
    private long genero_id;
    private long endereco_id;
    private String nome;
    private String apelido;
    private byte idade;
    private String passoword;
}
