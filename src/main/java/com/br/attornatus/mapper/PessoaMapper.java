package com.br.attornatus.mapper;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaResponse;
import com.br.attornatus.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper mapper;


    public Pessoa toEntityPessoa(PessoaRequest pessoaRequest) {
        return mapper.map(pessoaRequest, Pessoa.class);
    }

    public PessoaResponse toResponsePessoa(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaResponse.class);
    }
}
