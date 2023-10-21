package br.com.gustavo.api.services;

import br.com.gustavo.api.model.Contato;
import br.com.gustavo.api.repositories.ContatoRepository;

public class ContatoService 
{
    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) 
    {
        this.contatoRepository = contatoRepository;
    }

    public Contato salvar(Contato contato) 
    {
        return contatoRepository.save(contato);
    }

    public Contato buscarPorId(Long id) 
    {
        return contatoRepository.findById(id).orElse(null);
    }
}
