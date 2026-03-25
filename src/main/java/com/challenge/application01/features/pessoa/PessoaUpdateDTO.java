package com.challenge.application01.features.pessoa;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaUpdateDTO {
    private String nome;
    private String apelido;
    private Byte idade;
    private Long endereco_id;
    private Long genero_id;
}
