package com.brenoricco.cursomc.services;

import java.util.Optional;

import com.brenoricco.cursomc.domains.Cliente;
import com.brenoricco.cursomc.repositories.ClienteRepository;
import com.brenoricco.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() ->
        new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
                                    ", Tipo: " + Cliente.class.getName()));
    }
}
