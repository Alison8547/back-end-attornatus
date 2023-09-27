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
public class EnderecoPrincipalRequest {

    @NotBlank(message = "Não pode ser null ou vazio!")
    private String principal;
}
