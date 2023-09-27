package com.br.attornatus.builders;

import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.entity.Endereco;

public class EnderecoBuilder {

    public static Endereco newEnderecoEntity() {
        return Endereco.builder()
                .id(1)
                .cep("23812-310")
                .logradouro("Rua do sol")
                .numero("234")
                .cidade("Recife")
                .principal(false)
                .build();
    }

    public static EnderecoResponse newEnderecoResponseEntity() {
        return EnderecoResponse.builder()
                .id(1)
                .cep("23812-310")
                .logradouro("Rua do sol")
                .numero("234")
                .cidade("Recife")
                .principal(false)
                .build();
    }
}
