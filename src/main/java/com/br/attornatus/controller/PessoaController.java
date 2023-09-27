package com.br.attornatus.controller;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping
public interface PessoaController {

    @PostMapping("/create-pessoa")
    ResponseEntity<PessoaResponse> createPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @PutMapping("/edit-pessoa/{idPessoa}")
    ResponseEntity<PessoaResponse> editPessoa(@PathVariable(name = "idPessoa") Integer idPessoa, @Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping("/consult-pessoa/{idPessoa}")
    ResponseEntity<PessoaResponse> consultPessoa(@PathVariable(name = "idPessoa") Integer idPessoa);

    @GetMapping("/list-pessoas")
    ResponseEntity<List<PessoaResponse>> listPessoas();

    @GetMapping("/list-pessoa-enderecos/{idPessoa}")
    ResponseEntity<List<PessoaEnderecoListResponse>> listPessoaEnderecos(@PathVariable(name = "idPessoa") Integer idPessoa);

}
