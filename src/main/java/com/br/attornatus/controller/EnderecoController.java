package com.br.attornatus.controller;

import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping
public interface EnderecoController {

    @Operation(summary = "Criar um Endereço para a Pessoa", description = "Salvar um endereço no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @PostMapping("/create-endereco/{idPessoa}")
    ResponseEntity<EnderecoResponse> createEndereco(@PathVariable(name = "idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoRequest enderecoRequest);

    @Operation(summary = "Colocar seu Endereço como principal", description = "Editar Endereço principal no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @PutMapping("/edit-principal-endereco/{idEndereco}")
    ResponseEntity<EnderecoResponse> editPrincipalEndereco(@PathVariable(name = "idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoPrincipalRequest principalRequest);
}
