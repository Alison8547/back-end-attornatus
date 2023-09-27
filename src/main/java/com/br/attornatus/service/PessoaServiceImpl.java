package com.br.attornatus.service;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import com.br.attornatus.entity.Pessoa;
import com.br.attornatus.exception.BusinessException;
import com.br.attornatus.mapper.PessoaMapper;
import com.br.attornatus.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper mapper;

    @Override
    public PessoaResponse createPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoaCreate = pessoaRepository.save(mapper.toEntityPessoa(pessoaRequest));
        log.info("Pessoa criada com sucesso!");

        return mapper.toResponsePessoa(pessoaCreate);
    }

    @Override
    public PessoaResponse editPessoa(Integer idPessoa, PessoaRequest pessoaRequest) {
        Pessoa pessoaEdit = findPessoa(idPessoa);
        pessoaEdit.setNome(pessoaRequest.getNome());
        pessoaEdit.setDataNascimento(pessoaRequest.getDataNascimento());

        pessoaRepository.save(pessoaEdit);
        log.info("Pessoa editada com sucesso!");

        return mapper.toResponsePessoa(pessoaEdit);
    }

    @Override
    public PessoaResponse consultPessoa(Integer idPessoa) {
        return mapper.toResponsePessoa(findPessoa(idPessoa));
    }

    @Override
    public List<PessoaResponse> listPessoas() {
        return pessoaRepository.findAll().stream()
                .map(mapper::toResponsePessoa)
                .toList();
    }

    @Override
    public List<PessoaEnderecoListResponse> pessoaEnderecoList(Integer idPessoa) {
        return pessoaRepository.findAllById(Collections.singleton(findPessoa(idPessoa).getId())).stream()
                .map(mapper::toResponsePessoaEndereco)
                .toList();
    }


    public Pessoa findPessoa(Integer idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new BusinessException("Pessoa não encontrada!"));
    }
}
