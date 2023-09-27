package com.br.attornatus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEnderecoListResponse {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoResponse> enderecoList;
}
