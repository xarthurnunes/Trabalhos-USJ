package br.edu.usj.sistemaxyz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrdemServicoRepository extends CrudRepository<OrdemServico, Long> {
    List<OrdemServico> findAll();
    
}