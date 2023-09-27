package com.br.attornatus.controller;

import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping
public interface EnderecoController {

    @PostMapping("/create-endereco/{idPessoa}")
    ResponseEntity<EnderecoResponse> createEndereco(@PathVariable(name = "idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoRequest enderecoRequest);

    @PutMapping("/edit-principal-endereco/{idEndereco}")
    ResponseEntity<EnderecoResponse> editPrincipalEndereco(@PathVariable(name = "idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoPrincipalRequest principalRequest);
}
