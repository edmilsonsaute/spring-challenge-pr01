package com.challenge.application01.features.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaResponseDTO registarPessoa(PessoaRequestDTO pessoaRequestDTO){

        PessoaModel pessoa = PessoaModel.builder()
                        .nome(pessoaRequestDTO.getNome())
                        .apelido(pessoaRequestDTO.getApelido())
                        .idade(pessoaRequestDTO.getIdade())
                        .genero_id(pessoaRequestDTO.getGenero_id())
                        .endereco_id(pessoaRequestDTO.getEndereco_id())
                        .password(pessoaRequestDTO.getPassword())
                        .build();
                        
        PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                        .nome(pessoa.getNome())
                        .apelido(pessoa.getApelido())
                        .idade(pessoa.getIdade())
                        .genero_id(pessoa.getGenero_id())
                        .endereco_id(pessoa.getEndereco_id())
                        .build();
        pessoaRepository.save(pessoa);

        return pessoaResponseDTO;
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

    public PessoaResponseDTO obterPessoaViaId(Long id){

        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);

        if(pessoa.isEmpty()){
            throw new RuntimeException("Pessoa nao encontrada");
        }

        PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                            .nome(pessoa.get().getNome())
                            .apelido(pessoa.get().getApelido())
                            .idade(pessoa.get().getIdade())
                            .genero_id(pessoa.get().getGenero_id())
                            .endereco_id(pessoa.get().getEndereco_id())
                            .build();
        
        return pessoaResponseDTO;
    }
}
