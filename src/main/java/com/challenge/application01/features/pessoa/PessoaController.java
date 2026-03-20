package com.challenge.application01.features.pessoa;

import java.net.URI;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping()
    public ResponseEntity<String> registarPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO){
        
        PessoaResponseDTO pessoaRegistada = pessoaService.registarPessoa(pessoaRequestDTO);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(pessoaRegistada.getId())
            .toUri();


        return ResponseEntity.created(location).body("Pessoa registada com sucesso!");
    }
}
