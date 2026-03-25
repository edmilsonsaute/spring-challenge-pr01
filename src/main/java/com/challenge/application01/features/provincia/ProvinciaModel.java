package com.challenge.application01.features.provincia;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "provincia")
public class ProvinciaModel {

    @Id
    private Long id;
    private String nome;
    private Long pais_id;
}
