package br.com.gustavo.api.controller;

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

import br.com.gustavo.api.model.Contato;
import br.com.gustavo.api.repositories.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) 
    {
        Contato novoContato = contatoRepository.save(contato);
        return new ResponseEntity<>(novoContato, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable Long id) 
    {
        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isPresent()) {
            return new ResponseEntity<>(contato.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) 
    {
        Optional<Contato> contatoExistente = contatoRepository.findById(id);
        if (contatoExistente.isPresent()) {
            Contato contato = contatoExistente.get();
            contato.setNome(contatoAtualizado.getNome());
            contato.setTelefone(contatoAtualizado.getTelefone());
            contato.setEmail(contatoAtualizado.getEmail());
            Contato dadosContato = contatoRepository.save(contato);
            return new ResponseEntity<>(dadosContato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirContato(@PathVariable Long id) 
    {
        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isPresent()) {
            contatoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
