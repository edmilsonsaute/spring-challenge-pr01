package com.challenge.application01.features.pais;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.application01.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public PaisModel registarPais(PaisRequestDTO paisRequestDTO) {
        PaisModel pais = PaisModel.builder()
                .nome(paisRequestDTO.getNome())
                .sigla(paisRequestDTO.getSigla())
                .build();
        paisRepository.save(pais);
        return pais;
    }

    public List<PaisModel> listarPaises() {
        Iterable<PaisModel> paises = paisRepository.findAll();
        List<PaisModel> listaPaises = new ArrayList<>();
        paises.forEach(listaPaises::add);
        return listaPaises;
    }

    public PaisModel obterPaisViaId(long id) {
        PaisModel pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pais nao encontrado"));
        return pais;
    }

    public PaisModel atualizarPais(Long id, PaisModel paisDados) {
        PaisModel pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pais nao encontrado"));

        if (paisDados.getNome() != null) {
            pais.setNome(paisDados.getNome());
        }

        if (paisDados.getSigla() != null) {
            pais.setSigla(paisDados.getSigla());
        }

        paisRepository.save(pais);

        return pais;
    }

    public void apagarPais(long id){
        paisRepository.deleteById(id);;
    }
}
