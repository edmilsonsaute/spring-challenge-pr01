package com.challenge.application01.features.provincia;

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
@RequestMapping("/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService){
        this.provinciaService = provinciaService;
    }
    
    @PostMapping()
    public ResponseEntity<ProvinciaModel> registarProvincia(@RequestBody ProvinciaRequestDTO provinciaRequestDTO){
        ProvinciaModel provincia = provinciaService.registarProvincia(provinciaRequestDTO);
        return ResponseEntity.status(201).body(provincia);
    }

    @GetMapping()
    public ResponseEntity<List<ProvinciaModel>> listarPessoas(){
        List<ProvinciaModel> provincias = provinciaService.listarProvincias();
        return ResponseEntity.status(200).body(provincias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaModel> obterPaisViaId(@PathVariable Long id){
        ProvinciaModel provincia = provinciaService.obterProvinciaViaId(id);
        return ResponseEntity.status(200).body(provincia);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProvinciaModel> atualizarPais(@PathVariable Long id, @RequestBody ProvinciaModel provinciaModel){
        ProvinciaModel provincia = provinciaService.actualizarProvincia(id, provinciaModel);
        return ResponseEntity.status(200).body(provincia);
    }

    @DeleteMapping("/{id}")
    public void apagarProvincia(@PathVariable Long id){
        provinciaService.apagarProvincia(id);
    }
}
