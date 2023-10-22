package br.com.gustavo.api;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavo.api.services.PessoaService;

@SpringBootTest
public class PessoaServiceTests {
    @Test
    public void testEmailValido() 
    {
        assertTrue(PessoaService.verificaEmail("email@email.com"));        
        assertTrue(PessoaService.verificaEmail("email123@email.com.br"));
        assertTrue(PessoaService.verificaEmail("email.email@email.co"));
    }

    @Test
    public void testEmailInvalido() 
    {
        assertFalse(PessoaService.verificaEmail("email"));
        assertFalse(PessoaService.verificaEmail("email@.com")); 
        assertFalse(PessoaService.verificaEmail("email@.sadsad"));
        assertFalse(PessoaService.verificaEmail("email@sadsad."));
        assertFalse(PessoaService.verificaEmail("@email.com"));
    }
}
