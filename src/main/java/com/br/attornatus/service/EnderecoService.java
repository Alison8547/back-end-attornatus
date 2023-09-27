package com.br.attornatus.service;

import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;

import javax.transaction.Transactional;

public interface EnderecoService {

    @Transactional
    EnderecoResponse createEndereco(Integer idPessoa, EnderecoRequest enderecoRequest);

    @Transactional
    EnderecoResponse principalEndereco(Integer idEndereco, EnderecoPrincipalRequest principalRequest);

}
