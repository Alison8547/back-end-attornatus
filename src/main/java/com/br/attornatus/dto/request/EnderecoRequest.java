package com.br.attornatus.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Logradouro do seu endereço", example = "Rua do sol")
    private String logradouro;

    @NotBlank(message = "Não pode ser null ou vazio!")
    @Schema(description = "Cep do seu endereço", example = "23812-310")
    private String cep;

    @NotBlank(message = "Não pode ser null ou vazio!")
    @Schema(description = "Número do seu endereço", example = "123")
    private String numero;

    @NotBlank(message = "Não pode ser null ou vazio!")
    @Schema(description = "Cidade do seu endereço", example = "Recife")
    private String cidade;

}
