package com.br.attornatus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {

    private Integer id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String principal;
}
