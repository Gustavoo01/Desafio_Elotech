package br.com.gustavo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.api.model.Pessoa;
import br.com.gustavo.api.repositories.PessoaRepository;
import br.com.gustavo.api.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) 
    {
        return (ResponseEntity<Pessoa>) pessoaService.cadastrar(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() 
    {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) 
    {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) 
    {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            Pessoa pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setCpf(pessoaAtualizada.getCpf());
            pessoa.setDataNascimento(pessoaAtualizada.getDataNascimento());
            Pessoa dadosPessoa = pessoaRepository.save(pessoa);
            return new ResponseEntity<>(dadosPessoa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable Long id) 
    {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
