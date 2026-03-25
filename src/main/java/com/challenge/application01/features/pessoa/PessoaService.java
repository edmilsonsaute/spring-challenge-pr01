package com.challenge.application01.features.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.application01.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaResponseDTO registarPessoa(PessoaRequestDTO pessoaRequestDTO) {

        PessoaModel pessoa = PessoaModel.builder()
                .nome(pessoaRequestDTO.getNome())
                .apelido(pessoaRequestDTO.getApelido())
                .idade(pessoaRequestDTO.getIdade())
                .genero_id(pessoaRequestDTO.getGenero_id())
                .endereco_id(pessoaRequestDTO.getEndereco_id())
                .password(pessoaRequestDTO.getPassword())
                .build();

        PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .apelido(pessoa.getApelido())
                .idade(pessoa.getIdade())
                .genero_id(pessoa.getGenero_id())
                .endereco_id(pessoa.getEndereco_id())
                .build();
        pessoaRepository.save(pessoa);

        return pessoaResponseDTO;
    }

    public List<PessoaResponseDTO> listarPessoas() {

        List<PessoaModel> listaPessoa = new ArrayList<>();

        Iterable<PessoaModel> pessoas = pessoaRepository.findAll();

        pessoas.forEach(listaPessoa::add);

        List<PessoaResponseDTO> responseDTOs = new ArrayList<>();

        for (PessoaModel pessoaModel : listaPessoa) {
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

    public PessoaResponseDTO obterPessoaViaId(Long id) {

        PessoaModel pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa nao encontrada"));

        PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .apelido(pessoa.getApelido())
                .idade(pessoa.getIdade())
                .genero_id(pessoa.getGenero_id())
                .endereco_id(pessoa.getEndereco_id())
                .build();

        return pessoaResponseDTO;
    }

    public PessoaResponseDTO atualizarPessoa(Long id, PessoaUpdateDTO pessoaUpdateDTO) {
        PessoaModel pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa nao encontrada"));

        if (pessoaUpdateDTO.getNome() != null) {
            pessoa.setNome(pessoaUpdateDTO.getNome());
        }

        if (pessoaUpdateDTO.getApelido() != null) {
            pessoa.setApelido(pessoaUpdateDTO.getApelido());
        }

        if (pessoaUpdateDTO.getIdade() >= 0) {
            pessoa.setIdade(pessoaUpdateDTO.getIdade());
        }

        if (pessoaUpdateDTO.getGenero_id() >= 1) {
            pessoa.setGenero_id(pessoaUpdateDTO.getGenero_id());
        }

        if (pessoaUpdateDTO.getEndereco_id() >= 1) {
            pessoa.setEndereco_id(pessoaUpdateDTO.getEndereco_id());
        }

        PessoaResponseDTO pessoaResponseDTO = PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .apelido(pessoa.getApelido())
                .idade(pessoa.getIdade())
                .genero_id(pessoa.getGenero_id())
                .endereco_id(pessoa.getEndereco_id())
                .build();

        pessoaRepository.save(pessoa);
        return pessoaResponseDTO;
    }

    public void apagarPessoa(Long id) {
        PessoaModel pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa nao encontrada"));

        pessoaRepository.delete(pessoa);
    }
}
