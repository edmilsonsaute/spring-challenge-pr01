package com.challenge.application01.features.endereco;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequestDTO {
    
    @NotNull(message = "Distrito é obrigatorio.")
    private String distrito;

    @NotNull(message = "Bairro é obrigatorio.")
    private String bairro;

    @NotNull(message = "País é obrigatorio.")
    private Long pais_id;

    @NotNull(message = "Provincia é obrigatorio.")
    private Long provincia_id;
}
