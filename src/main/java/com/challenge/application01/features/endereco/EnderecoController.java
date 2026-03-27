package com.challenge.application01.features.endereco;

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

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    protected EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping()
    public ResponseEntity<EnderecoModel> registarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {

        EnderecoModel endereco = enderecoService.registarEndereco(enderecoRequestDTO);

        return ResponseEntity.status(201).body(endereco);
    }

    @GetMapping()
    public ResponseEntity<List<EnderecoModel>> listarEnderecos() {
        List<EnderecoModel> enderecos = enderecoService.listarEnderecos();

        return ResponseEntity.status(200).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> obterEnderecoViaId(@PathVariable Long id) {
        EnderecoModel endereco = enderecoService.obterEnderecoViaId(id);

        return ResponseEntity.status(200).body(endereco);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EnderecoModel> atualizarEndereco(@PathVariable Long id,
            @RequestBody EnderecoModel enderecoModel) {
        EnderecoModel endereco = enderecoService.atualizarEndereco(id, enderecoModel);

        return ResponseEntity.status(200).body(endereco);
    }

    @DeleteMapping("/{id}")
    public void apagarEndereco(@PathVariable Long id) {
        enderecoService.apagarEndereco(id);
    }

}
