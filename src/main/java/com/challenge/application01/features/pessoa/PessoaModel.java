package com.challenge.application01.features.pessoa;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Table(name = "pessoa")
public class PessoaModel {
    
    @Id
    private Long id;

    private long genero_id;
    private long endereco_id;
    private byte idade;
    private String nome;
    private String apelido;
    private String password;
    

}
