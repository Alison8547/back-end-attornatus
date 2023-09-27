package com.br.attornatus.builders;

import com.br.attornatus.dto.request.EnderecoRequest;
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
                .idPessoa(1)
                .pessoa(PessoaBuilder.newPessoaEntity())
                .build();
    }

    public static Endereco newEnderecoEntityCepInvalid() {
        return Endereco.builder()
                .id(1)
                .cep("2381222-310")
                .logradouro("Rua do sol")
                .numero("234")
                .cidade("Recife")
                .principal(false)
                .idPessoa(1)
                .pessoa(PessoaBuilder.newPessoaEntity())
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

    public static EnderecoRequest newEnderecoResquestEntity() {
        return EnderecoRequest.builder()
                .cep("23812-310")
                .logradouro("Rua do sol")
                .numero("234")
                .cidade("Recife")
                .build();
    }

    public static EnderecoRequest newEnderecoResquestEntityCepInvalid() {
        return EnderecoRequest.builder()
                .cep("23822212-310")
                .logradouro("Rua do sol")
                .numero("234")
                .cidade("Recife")
                .build();
    }
}
