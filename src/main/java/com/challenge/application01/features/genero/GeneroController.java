package com.challenge.application01.features.genero;

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
@RequestMapping("/generos")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService){
        this.generoService = generoService;
    }

    @PostMapping()
    public ResponseEntity<GeneroModel> registarGenero(@RequestBody GeneroRequestDTO generoRequestDTO){
        GeneroModel genero = generoService.registarGenero(generoRequestDTO);

        return ResponseEntity.status(201).body(genero);
    }

    @GetMapping
    public ResponseEntity<List<GeneroModel>> listarGeneros(){
        List<GeneroModel> generos = generoService.listarGeneros();

        return ResponseEntity.status(200).body(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroModel> obterGeneroViaId(@PathVariable Long id){
        GeneroModel genero = generoService.obterGeneroViaId(id);
        return ResponseEntity.status(200).body(genero);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GeneroModel> atualizarGenero(@PathVariable Long id, @RequestBody GeneroModel generoModel){
        GeneroModel genero = generoService.atualizarGenero(id, generoModel);
        return ResponseEntity.status(200).body(genero);
    }

    @DeleteMapping("/{id}")
    public void apagarGenero(@PathVariable Long id){
        generoService.apagarGenero(id);
    }
}
