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

    private Long id;
    private Long genero_id;
    private Long endereco_id;
    private String nome;
    private String apelido;
    private Byte idade;
}
