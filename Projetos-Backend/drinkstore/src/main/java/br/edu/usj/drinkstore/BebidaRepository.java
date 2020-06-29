package br.edu.usj.drinkstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BebidaRepository extends CrudRepository<Bebida, Long> {
    List<Bebida> findAll();
    List<Bebida> findByNomeContainingIgnoreCase(String nome);
    
}