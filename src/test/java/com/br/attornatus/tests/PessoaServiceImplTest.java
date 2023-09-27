package com.br.attornatus.tests;

import com.br.attornatus.builders.PessoaBuilder;
import com.br.attornatus.dto.response.EnderecoResponse;
import com.br.attornatus.dto.response.PessoaEnderecoListResponse;
import com.br.attornatus.dto.response.PessoaResponse;
import com.br.attornatus.entity.Pessoa;
import com.br.attornatus.exception.BusinessException;
import com.br.attornatus.mapper.PessoaMapper;
import com.br.attornatus.repository.PessoaRepository;
import com.br.attornatus.service.PessoaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceImplTest {

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper mapper;


    @Test
    public void testMustCreatePessoaWithSuccess() {
        //(SETUP)
        when(pessoaRepository.save(any())).thenReturn(PessoaBuilder.newPessoaEntity());
        when(mapper.toResponsePessoa(any())).thenReturn(PessoaBuilder.newPessoaResponse());

        //(ACT)
        PessoaResponse pessoa = pessoaService.createPessoa(PessoaBuilder.newPessoaRequest());

        //(ASSERT)
        assertNotNull(pessoa);
        assertNotNull(pessoa.getId());
        assertEquals(1, pessoa.getId());
        assertEquals("Alison", pessoa.getNome());
        assertEquals(LocalDate.of(1998, 5, 11), pessoa.getDataNascimento());

    }

    @Test
    public void testMustEditPessoaWithSuccess() {
        //(SETUP)
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(PessoaBuilder.newPessoaEntity()));
        when(pessoaRepository.save(any())).thenReturn(PessoaBuilder.newPessoaEntityTwo());
        when(mapper.toResponsePessoa(any())).thenReturn(PessoaBuilder.newPessoaResponseTwo());

        //(ACT)
        PessoaResponse pessoaEdit = pessoaService.editPessoa(PessoaBuilder.newPessoaEntity().getId(), PessoaBuilder.newPessoaEditRequest());

        //(ASSERT)
        assertNotNull(pessoaEdit);
        assertEquals("Alison Santos", pessoaEdit.getNome());
        assertEquals(LocalDate.of(2002, 11, 30), pessoaEdit.getDataNascimento());

    }

    @Test
    public void testMustConsultPessoaWithSuccess() {
        //(SETUP)
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(PessoaBuilder.newPessoaEntity()));
        when(mapper.toResponsePessoa(any())).thenReturn(PessoaBuilder.newPessoaResponse());
        //(ACT)
        PessoaResponse pessoa = pessoaService.consultPessoa(PessoaBuilder.newPessoaEntity().getId());

        //(ASSERT)
        assertNotNull(pessoa);
        assertEquals(1, pessoa.getId());
        assertEquals("Alison", pessoa.getNome());


    }

    @Test
    public void testMustListPessoasWithSuccess() {
        //(SETUP)
        when(pessoaRepository.findAll()).thenReturn(List.of(PessoaBuilder.newPessoaEntity(), PessoaBuilder.newPessoaEntityTwo()));
        when(mapper.toResponsePessoa(any())).thenReturn(PessoaBuilder.newPessoaResponse());

        //(ACT)
        List<PessoaResponse> listPessoas = pessoaService.listPessoas();

        //(ASSERT)
        assertNotNull(listPessoas);
        assertTrue(listPessoas.size() > 0);
        assertEquals(2, listPessoas.size());


    }

    @Test
    public void testMustPessoaEnderecoListWithSuccess() {
        //(SETUP)
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(PessoaBuilder.newPessoaEnderecoEntity()));
        when(mapper.toResponsePessoaEndereco(any())).thenReturn(PessoaBuilder.newPessoaEnderecoEntityTwo());

        //(ACT)
        PessoaEnderecoListResponse pessoaEnderecoList = pessoaService.pessoaEnderecoList(PessoaBuilder.newPessoaEnderecoEntity().getId());

        //(ASSERT)
        assertNotNull(pessoaEnderecoList);
        assertEquals("Rua do sol", pessoaEnderecoList.getEnderecoList().stream().map(EnderecoResponse::getLogradouro).findAny().get());
        assertEquals("234", pessoaEnderecoList.getEnderecoList().stream().map(EnderecoResponse::getNumero).findAny().get());
        assertEquals("Recife", pessoaEnderecoList.getEnderecoList().stream().map(EnderecoResponse::getCidade).findAny().get());
        assertEquals(false, pessoaEnderecoList.getEnderecoList().stream().map(EnderecoResponse::getPrincipal).findAny().get());


    }

    @Test
    public void testMustFindByIdPessoaWithSuccess() {
        //(SETUP)
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(PessoaBuilder.newPessoaEntity()));

        //(ACT)
        Pessoa pessoa = pessoaService.findPessoa(PessoaBuilder.newPessoaEntity().getId());

        //(ASSERT)
        assertNotNull(pessoa);
        assertEquals(1, pessoa.getId());


    }

    @Test(expected = BusinessException.class)
    public void testMustFindByIdWithError() {
        //(SETUP)
        Integer search = 12;
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.empty());

        //(ACT)
        Pessoa pessoa = pessoaService.findPessoa(search);

        //(ASSERT)
        assertNull(pessoa);
    }
}
