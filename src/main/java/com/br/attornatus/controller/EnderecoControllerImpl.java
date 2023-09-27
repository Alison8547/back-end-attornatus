package com.br.attornatus.controller;

import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnderecoControllerImpl implements EnderecoController {

    private final EnderecoService enderecoService;

    @Override
    public ResponseEntity<EnderecoResponse> createEndereco(Integer idPessoa, EnderecoRequest enderecoRequest) {
        return new ResponseEntity<>(enderecoService.createEndereco(idPessoa, enderecoRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EnderecoResponse> editPrincipalEndereco(Integer idEndereco, EnderecoPrincipalRequest principalRequest) {
        return new ResponseEntity<>(enderecoService.principalEndereco(idEndereco, principalRequest), HttpStatus.OK);
    }
}
