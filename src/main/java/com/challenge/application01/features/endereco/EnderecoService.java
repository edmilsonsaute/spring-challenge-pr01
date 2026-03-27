package com.challenge.application01.features.endereco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.application01.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoModel registarEndereco(EnderecoRequestDTO enderecoRequestDTO){
        EnderecoModel endereco = EnderecoModel.builder()
                .distrito(enderecoRequestDTO.getDistrito())
                .bairro(enderecoRequestDTO.getBairro())
                .pais_id(enderecoRequestDTO.getPais_id())
                .provincia_id(enderecoRequestDTO.getProvincia_id())
                .build();
        enderecoRepository.save(endereco);

        return endereco;
    }

    public List<EnderecoModel> listarEnderecos(){

        List<EnderecoModel> listarEnderecos = new ArrayList<>();

        Iterable<EnderecoModel> enderecos = enderecoRepository.findAll();

        enderecos.forEach(listarEnderecos::add);
        return listarEnderecos;
    }

    public EnderecoModel obterEnderecoViaId(Long id){
        EnderecoModel endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereco nao encontrado"));

        return endereco;
    }

    public EnderecoModel atualizarEndereco(Long id, EnderecoModel enderecoModel){
        EnderecoModel endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereco nao encontrado"));

        if(enderecoModel.getDistrito() != null){
            endereco.setDistrito(enderecoModel.getDistrito());
        }

        if(enderecoModel.getBairro() != null){
            endereco.setBairro(enderecoModel.getBairro());
        }

        if(enderecoModel.getPais_id() != null){
            endereco.setPais_id(enderecoModel.getPais_id());
        }

        if(enderecoModel.getProvincia_id() != null){
            endereco.setProvincia_id(enderecoModel.getProvincia_id());
        }

        enderecoRepository.save(endereco);
        return endereco;
    }

    public void apagarEndereco(Long id){
         EnderecoModel endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereco nao encontrado"));

         enderecoRepository.delete(endereco);
    }
}
