package com.br.attornatus.controller;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import com.br.attornatus.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PessoaControllerImpl implements PessoaController {

    private final PessoaService pessoaService;

    @Override
    public ResponseEntity<PessoaResponse> createPessoa(PessoaRequest pessoaRequest) {
        return new ResponseEntity<>(pessoaService.createPessoa(pessoaRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PessoaResponse> editPessoa(Integer idPessoa, PessoaRequest pessoaRequest) {
        return new ResponseEntity<>(pessoaService.editPessoa(idPessoa, pessoaRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PessoaResponse> consultPessoa(Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.consultPessoa(idPessoa), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PessoaResponse>> listPessoas() {
        return new ResponseEntity<>(pessoaService.listPessoas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PessoaEnderecoListResponse> listPessoaEnderecos(Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.pessoaEnderecoList(idPessoa), HttpStatus.OK);
    }
}
