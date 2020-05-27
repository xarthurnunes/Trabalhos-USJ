package br.edu.usj.calculadora;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OperacaoRepository extends CrudRepository<Operacao, Long>{
    List<Operacao> findAll();

    
}