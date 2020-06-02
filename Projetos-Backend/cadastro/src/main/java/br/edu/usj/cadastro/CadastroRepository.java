package br.edu.usj.cadastro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository <Cadastros, Long> {

    List<Cadastros> findAll();
    List<Cadastros> findByNome(String nome);
    
}