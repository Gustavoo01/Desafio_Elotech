package br.com.gustavo.api.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.gustavo.api.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> { }
