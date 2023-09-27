package com.br.attornatus.service;

import com.br.attornatus.dto.request.PessoaRequest;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;

import javax.transaction.Transactional;
import java.util.List;

public interface PessoaService {

    @Transactional
    PessoaResponse createPessoa(PessoaRequest pessoaRequest);

    @Transactional
    PessoaResponse editPessoa(Integer idPessoa, PessoaRequest pessoaRequest);

    PessoaResponse consultPessoa(Integer idPessoa);

    List<PessoaResponse> listPessoas();

    PessoaEnderecoListResponse pessoaEnderecoList(Integer idPessoa);
}
