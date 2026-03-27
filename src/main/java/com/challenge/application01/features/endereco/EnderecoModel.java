package com.challenge.application01.features.endereco;

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
@Table(name = "endereco")
public class EnderecoModel {
    @Id
    private Long id;
    private String distrito;
    private String bairro;
    private Long pais_id;
    private Long provincia_id;
}
