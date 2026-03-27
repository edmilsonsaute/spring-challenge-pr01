package com.challenge.application01.features.genero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.application01.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public GeneroModel registarGenero(GeneroRequestDTO generoRequestDTO) {
        GeneroModel genero = GeneroModel.builder()
                .nome(generoRequestDTO.getNome())
                .build();

        generoRepository.save(genero);
        return genero;
    }

    public List<GeneroModel> listarGeneros() {
        List<GeneroModel> listaGeneros = new ArrayList<>();
        Iterable<GeneroModel> generos = generoRepository.findAll();

        generos.forEach(listaGeneros::add);
        return listaGeneros;
    }

    public GeneroModel obterGeneroViaId(Long id) {
        GeneroModel genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero nao encontrado"));

        return genero;
    }

    public GeneroModel atualizarGenero(Long id, GeneroModel generoModel) {
        GeneroModel genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero nao encontrado"));

        if (generoModel.getNome() != null) {
            genero.setNome(generoModel.getNome());
        }

        generoRepository.save(genero);
        return genero;
    }

    public void apagarGenero(Long id) {
        GeneroModel genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero nao encontrado"));

        generoRepository.delete(genero);

    }
}
