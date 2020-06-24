package br.edu.usj.drinkstorebackend;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BebidaRepository extends CrudRepository<Bebida, Long> {
    List<Bebida> findAll();
    List<Bebida> findByNome(String nome);
    List<Bebida> findByNomeContainingIgnoreCase(String nome);
    List<Bebida> findByNomeContainingIgnoreCaseOrderByPrecoDesc(String nome);

    @Query(value = "select avg(preco) from public.bebida where upper(nome) like upper('_?1_')", nativeQuery = true)
    Double calculaPrecoMedio(String nome);
    
}