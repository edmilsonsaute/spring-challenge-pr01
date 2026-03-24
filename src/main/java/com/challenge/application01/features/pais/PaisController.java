package com.challenge.application01.features.pais;

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
@RequestMapping("/pais")
public class PaisController {
    
    private final PaisService paisService;

    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @PostMapping()
    public ResponseEntity<PaisModel> registarPais(@RequestBody PaisRequestDTO paisRequestDTO){
        PaisModel pais = paisService.registarPais(paisRequestDTO);
        return ResponseEntity.status(201).body(pais);
    }

    @GetMapping()
    public ResponseEntity<List<PaisModel>> listarPessoas(){
        List<PaisModel> paises = paisService.listarPaises();
        return ResponseEntity.status(200).body(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisModel> obterPaisViaId(@PathVariable long id){
        PaisModel pais = paisService.obterPaisViaId(id);
        return ResponseEntity.status(200).body(pais);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaisModel> atualizarPais(@PathVariable long id, @RequestBody PaisModel paisModel){
        PaisModel pais = paisService.atualizarPais(id, paisModel);
        return ResponseEntity.status(200).body(pais);
    }

    @DeleteMapping("/{id}")
    public void apagarPais(long id){
        paisService.apagarPais(id);
    }
}
