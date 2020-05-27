package br.edu.usj.contatos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contatos, Long>{

    List<Contatos> findAll();
    
}