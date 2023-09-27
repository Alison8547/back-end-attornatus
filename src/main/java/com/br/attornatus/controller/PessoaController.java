package com.br.attornatus.controller;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping
public interface PessoaController {
    @Operation(summary = "Criar uma uma Pessoa", description = "Salvar uma pessoa no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @PostMapping("/create-pessoa")
    ResponseEntity<PessoaResponse> createPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @Operation(summary = "Editar uma Pessoa", description = "Editar uma Pessoa no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @PutMapping("/edit-pessoa/{idPessoa}")
    ResponseEntity<PessoaResponse> editPessoa(@PathVariable(name = "idPessoa") Integer idPessoa, @Valid @RequestBody PessoaRequest pessoaRequest);

    @Operation(summary = "Consultar uma Pessoa", description = "Consultar uma Pessoa no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Consultou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @GetMapping("/consult-pessoa/{idPessoa}")
    ResponseEntity<PessoaResponse> consultPessoa(@PathVariable(name = "idPessoa") Integer idPessoa);

    @Operation(summary = "Lista de Pessoas", description = "Retornar uma lista de Pessoas do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @GetMapping("/list-pessoas")
    ResponseEntity<List<PessoaResponse>> listPessoas();

    @Operation(summary = "Lista de Endereços da Pessoa", description = "Retornar uma lista de Endereços da Pessoa do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornou com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Foi gerada uma exceção"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção internal server")
            }
    )
    @GetMapping("/list-pessoa-enderecos/{idPessoa}")
    ResponseEntity<List<PessoaEnderecoListResponse>> listPessoaEnderecos(@PathVariable(name = "idPessoa") Integer idPessoa);

}
