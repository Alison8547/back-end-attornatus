package com.br.attornatus.builders;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import com.br.attornatus.entity.Pessoa;

import java.time.LocalDate;
import java.util.List;

public class PessoaBuilder {

    public static Pessoa newPessoaEntity() {
        return Pessoa.builder()
                .id(1)
                .nome("Alison")
                .dataNascimento(LocalDate.of(1998, 5, 11))
                .build();
    }

    public static Pessoa newPessoaEntityTwo() {
        return Pessoa.builder()
                .nome("Alison Santos")
                .dataNascimento(LocalDate.of(2002, 11, 30))
                .build();
    }

    public static Pessoa newPessoaEnderecoEntity() {
        return Pessoa.builder()
                .id(1)
                .nome("Alison")
                .dataNascimento(LocalDate.of(1998, 5, 11))
                .enderecoList(List.of(EnderecoBuilder.newEnderecoEntity()))
                .build();
    }

    public static PessoaEnderecoListResponse newPessoaEnderecoEntityTwo() {
        return PessoaEnderecoListResponse.builder()
                .id(2)
                .nome("Bruno")
                .dataNascimento(LocalDate.of(1998, 5, 11))
                .enderecoList(List.of(EnderecoBuilder.newEnderecoResponseEntity()))
                .build();
    }

    public static PessoaResponse newPessoaResponse() {
        return PessoaResponse.builder()
                .id(1)
                .nome("Alison")
                .dataNascimento(LocalDate.of(1998, 5, 11))
                .build();
    }

    public static PessoaResponse newPessoaResponseTwo() {
        return PessoaResponse.builder()
                .nome("Alison Santos")
                .dataNascimento(LocalDate.of(2002, 11, 30))
                .build();
    }

    public static PessoaRequest newPessoaRequest() {
        return PessoaRequest.builder()
                .nome("Alison")
                .dataNascimento(LocalDate.of(1998, 5, 11))
                .build();
    }

    public static PessoaRequest newPessoaEditRequest() {
        return PessoaRequest.builder()
                .nome("Alison Santos")
                .dataNascimento(LocalDate.of(2002, 11, 30))
                .build();
    }
}
