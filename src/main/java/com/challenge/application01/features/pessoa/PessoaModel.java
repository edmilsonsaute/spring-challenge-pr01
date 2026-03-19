package com.challenge.application01.features.pessoa;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PessoaModel {
    
    @Id
    private Long id;

    private Long genero_id;
    private Long endereco_id;
    private short idade;
    private String nome;
    private String apelido;
    

}
