package com.br.attornatus.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

    @NotBlank(message = "Não pode ser null ou vazio!")
    private String logradouro;

    @NotBlank(message = "Não pode ser null ou vazio!")
    private String cep;

    @NotBlank(message = "Não pode ser null ou vazio!")
    private String numero;

    @NotBlank(message = "Não pode ser null ou vazio!")
    private String cidade;

}
