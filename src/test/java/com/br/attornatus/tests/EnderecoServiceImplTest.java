package com.br.attornatus.tests;

import com.br.attornatus.builders.EnderecoBuilder;
import com.br.attornatus.builders.PessoaBuilder;
import com.br.attornatus.dto.request.EnderecoPrincipalRequest;
import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.entity.Endereco;
import com.br.attornatus.entity.Pessoa;
import com.br.attornatus.exception.BusinessException;
import com.br.attornatus.mapper.EnderecoMapper;
import com.br.attornatus.repository.EnderecoRepository;
import com.br.attornatus.service.EnderecoServiceImpl;
import com.br.attornatus.service.PessoaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceImplTest {

    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private EnderecoMapper mapper;

    @Mock
    private PessoaServiceImpl pessoaService;


    @Test
    public void testMustCreateEnderecoWithSuccess() {
        //(SETUP)
        when(enderecoRepository.save(any())).thenReturn(EnderecoBuilder.newEnderecoEntity());
        when(mapper.toEntityEndereco(any())).thenReturn(EnderecoBuilder.newEnderecoEntity());
        when(mapper.toResponseEndereco(any())).thenReturn(EnderecoBuilder.newEnderecoResponseEntity());
        Pessoa pessoa = PessoaBuilder.newPessoaEntity();
        pessoa.setEnderecoList(new ArrayList<>(List.of(new Endereco())));
        when(pessoaService.findPessoa(anyInt())).thenReturn(pessoa);

        //(ACT)
        EnderecoResponse endereco = enderecoService.createEndereco(pessoa.getId(), EnderecoBuilder.newEnderecoResquestEntity());

        //(ASSERT)
        assertNotNull(endereco);
        assertNotNull(endereco.getId());
        assertEquals(1, endereco.getId());
        assertEquals("Rua do sol", endereco.getLogradouro());

    }

    @Test(expected = BusinessException.class)
    public void testMustCepWithError() {
        //(SETUP)
        when(mapper.toEntityEndereco(any())).thenReturn(EnderecoBuilder.newEnderecoEntityCepInvalid());
        Pessoa pessoa = PessoaBuilder.newPessoaEntity();
        pessoa.setEnderecoList(new ArrayList<>(List.of(new Endereco())));
        when(pessoaService.findPessoa(anyInt())).thenReturn(pessoa);

        //(ACT)
        EnderecoResponse endereco = enderecoService.createEndereco(pessoa.getId(), EnderecoBuilder.newEnderecoResquestEntityCepInvalid());

        //(ASSERT)
        assertNull(endereco);
        assertThrows(BusinessException.class, () -> enderecoService.createEndereco(pessoa.getId(), EnderecoBuilder.newEnderecoResquestEntityCepInvalid()));


    }

    @Test
    public void testMustEditPrincipalEnderecoWithSuccess() {
        //(SETUP)
        when(enderecoRepository.findById(anyInt())).thenReturn(Optional.of(EnderecoBuilder.newEnderecoEntity()));
        when(enderecoRepository.save(any())).thenReturn(EnderecoBuilder.newEnderecoEntity());
        when(mapper.toResponseEndereco(any())).thenReturn(EnderecoBuilder.newEnderecoResponseEntity());

        //(ACT)
        EnderecoResponse principalEndereco = enderecoService.principalEndereco(EnderecoBuilder.newEnderecoEntity().getId(), EnderecoPrincipalRequest.builder().principal("Sim").build());
        //(ASSERT)
        assertNotNull(principalEndereco);
        assertEquals(false, principalEndereco.getPrincipal());

    }

    @Test(expected = BusinessException.class)
    public void testMustEditPrincipalEnderecoWithError() {
        //(SETUP)
        when(enderecoRepository.findById(anyInt())).thenReturn(Optional.of(EnderecoBuilder.newEnderecoEntity()));

        //(ACT)
        EnderecoResponse principalEndereco = enderecoService.principalEndereco(EnderecoBuilder.newEnderecoEntity().getId(), EnderecoPrincipalRequest.builder().principal("AAA").build());
        //(ASSERT)
        assertNull(principalEndereco);
        assertThrows(BusinessException.class, () -> enderecoService.principalEndereco(EnderecoBuilder.newEnderecoEntity().getId(), EnderecoPrincipalRequest.builder().principal("AAA").build()));

    }
}
