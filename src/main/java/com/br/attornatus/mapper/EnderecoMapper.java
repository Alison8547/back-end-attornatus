package com.br.attornatus.mapper;

import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.entity.Endereco;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoMapper {

    private final ModelMapper mapper;


    public Endereco toEntityEndereco(EnderecoRequest enderecoRequest) {
        return mapper.map(enderecoRequest, Endereco.class);
    }

    public EnderecoResponse toResponseEndereco(Endereco endereco) {
        return mapper.map(endereco, EnderecoResponse.class);
    }
}
