package com.challenge.application01.features.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public void registarPessoa(PessoaRequestDTO pessoaRequestDTO){

        PessoaModel pessoa = PessoaModel.builder()
                        .nome(pessoaRequestDTO.getNome())
                        .apelido(pessoaRequestDTO.getApelido())
                        .idade(pessoaRequestDTO.getIdade())
                        .genero_id(pessoaRequestDTO.getGenero_id())
                        .endereco_id(pessoaRequestDTO.getEndereco_id())
                        .build();
        pessoaRepository.save(pessoa);
    }

    public List<PessoaResponseDTO> listarPessoas(){
        
        List<PessoaModel> listaPessoa = new ArrayList<>();

        Iterable<PessoaModel> pessoas = pessoaRepository.findAll();

        pessoas.forEach(listaPessoa::add);

        List<PessoaResponseDTO> responseDTOs  = new ArrayList<>();

        for(PessoaModel pessoaModel : listaPessoa){
            PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                            .id(pessoaModel.getId())
                            .nome(pessoaModel.getNome())
                            .apelido(pessoaModel.getApelido())
                            .idade(pessoaModel.getIdade())
                            .endereco_id(pessoaModel.getEndereco_id())
                            .genero_id(pessoaModel.getGenero_id())
                            .build();
            responseDTOs.add(pessoaResponseDTO);
        }

        return responseDTOs;
    }
}
