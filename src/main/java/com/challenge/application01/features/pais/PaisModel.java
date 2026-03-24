package com.challenge.application01.features.pais;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table (name = "pais")
public class PaisModel {

    @Id
    private long id;
    private String nome;
    private String sigla;
}
