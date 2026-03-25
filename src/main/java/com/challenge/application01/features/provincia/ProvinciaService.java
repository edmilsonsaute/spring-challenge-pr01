package com.challenge.application01.features.provincia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.application01.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ProvinciaService {
    
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository){
        this.provinciaRepository = provinciaRepository;
    }

    public ProvinciaModel registarProvincia(ProvinciaRequestDTO provinciaRequestDTO){
        ProvinciaModel provincia = ProvinciaModel.builder()
                .nome(provinciaRequestDTO.getNome())
                .pais_id(provinciaRequestDTO.getPais_id())
                .build();
        provinciaRepository.save(provincia);
        return provincia;
    }

    public ProvinciaModel obterProvinciaViaId(Long id){
        ProvinciaModel provinciaModel = provinciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia nao encontrada"));

        return provinciaModel;
    }

    public List<ProvinciaModel> listarProvincias(){
        
        List<ProvinciaModel> listaProvincias = new ArrayList<>();
        Iterable<ProvinciaModel> provincias = provinciaRepository.findAll();

        provincias.forEach(listaProvincias::add);

        return listaProvincias;
    }

    public ProvinciaModel actualizarProvincia(Long id, ProvinciaModel provinciaModel){
        ProvinciaModel provincia = provinciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia nao encontrada"));

        if(provinciaModel.getNome() != null){
            provincia.setNome(provinciaModel.getNome());
        }

        if(provinciaModel.getPais_id() != null){
            provincia.setPais_id(provinciaModel.getPais_id());
        }

        provinciaRepository.save(provincia);

        return provincia;
    }

    public void apagarProvincia(Long id){
        ProvinciaModel provincia = provinciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provincia nao encontrada"));
        provinciaRepository.delete(provincia);;
    }
}
