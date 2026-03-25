package com.challenge.application01.features.pessoa;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping()
    public ResponseEntity<List<PessoaResponseDTO>> listarPessoas(){
        List<PessoaResponseDTO> pessoas = pessoaService.listarPessoas();

        return ResponseEntity.status(200).body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> obterPessoa(@PathVariable Long id){
        PessoaResponseDTO pessoa = pessoaService.obterPessoaViaId(id);

        return ResponseEntity.status(200).body(pessoa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaUpdateDTO pessoaUpdateDTO){
        PessoaResponseDTO pessoa = pessoaService.atualizarPessoa(id, pessoaUpdateDTO);
        return ResponseEntity.status(200).body(pessoa);
    }

    @DeleteMapping("/{id}")
    public void apagarPessoa(@PathVariable Long id){
        pessoaService.apagarPessoa(id);
    }
}
