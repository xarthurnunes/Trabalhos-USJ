package br.edu.usj.sistemaxyz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    
}