package com.br.attornatus.service;

import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.request.EnderecoRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.entity.Endereco;
import com.br.attornatus.entity.Pessoa;
import com.br.attornatus.exception.BusinessException;
import com.br.attornatus.mapper.EnderecoMapper;
import com.br.attornatus.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaServiceImpl pessoaService;
    private final EnderecoMapper mapper;


    @Override
    public EnderecoResponse createEndereco(Integer idPessoa, EnderecoRequest enderecoRequest) {
        Endereco entityEndereco = mapper.toEntityEndereco(enderecoRequest);
        Pessoa pessoa = pessoaService.findPessoa(idPessoa);

        if (enderecoRequest.getCep().length() > 9) {
            throw new BusinessException("Cep inválido!");
        }

        pessoa.getEnderecoList().add(entityEndereco);
        entityEndereco.setIdPessoa(pessoa.getId());
        entityEndereco.setPessoa(pessoa);
        entityEndereco.setPrincipal(false);

        enderecoRepository.save(entityEndereco);
        log.info("Endereço salvo para a {} com sucesso!", pessoa.getNome());
        return mapper.toResponseEndereco(entityEndereco);
    }

    @Override
    public EnderecoResponse principalEndereco(Integer idEndereco, EnderecoPrincipalRequest principalRequest) {
        Endereco endereco = findEndereco(idEndereco);


        if (!(principalRequest.getPrincipal().equalsIgnoreCase("Sim"))) {
            throw new BusinessException("Valor digitado invalido! Digite Sim para registrar esse endereço como principal");
        }
        endereco.setPrincipal(true);
        enderecoRepository.save(endereco);
        log.info("Principal endereço editado com sucesso!");
        return mapper.toResponseEndereco(endereco);
    }

    public Endereco findEndereco(Integer idEndereco) {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new BusinessException("Endereço não encontrado!"));
    }
}
