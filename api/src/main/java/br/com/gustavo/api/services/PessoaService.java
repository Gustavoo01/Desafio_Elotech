package br.com.gustavo.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.gustavo.api.model.Pessoa;
import br.com.gustavo.api.repositories.PessoaRepository;

public class PessoaService 
{
    @Autowired
    private PessoaRepository pessoaRepository;

    public ResponseEntity<?> cadastrar(Pessoa pessoa)
    {
        if(pessoa.getNome().equals("")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (pessoa.getDataNascimento().isBefore(LocalDate.now())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Pessoa novaPessoa = pessoaRepository.save(pessoa);
            return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
        }
    }

    public Pessoa salvar(Pessoa pessoa) 
    {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorId(Long id) 
    {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listar() 
    {
        return pessoaRepository.findAll();
    }
}