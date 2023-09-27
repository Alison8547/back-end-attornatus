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
public class EnderecoPrincipalRequest {

    @NotBlank(message = "Não pode ser null ou vazio!")
    @Schema(description = "Registrar seu principal endereço", example = "Sim")
    private String principal;
}
