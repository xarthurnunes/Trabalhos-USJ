package br.edu.usj.drinkstorebackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    BebidaRepository bebidaRepository;

    @GetMapping(value="/")
    public List<Bebida> getListar() {
        //listar todas as bebidas
        List<Bebida> lista = bebidaRepository.findAll();
        return lista;
    }

    @GetMapping(value="/{id}")
    public Bebida getMostrar(@PathVariable Long id) {
        //listar a bebida referente ao id
        Bebida bebida = bebidaRepository.findById(id).get();
        return bebida;
    }

    @PostMapping(value="/cadastrar")
    public Bebida postCadastrar(Bebida bebida) {
        //recebe a bebida preenchida no formulário e grava no banco
        Bebida bebidaSalva = bebidaRepository.save(bebida);
        return bebidaSalva;
    }

    @GetMapping(value="/deletar/{id}")
    public void getDeletarGet(@PathVariable Long id) {
        // deleta a bebida referente ao id
        bebidaRepository.deleteById(id);        
    }

    @DeleteMapping(value="/{id}")
    public void getDeletar(@PathVariable Long id) {
        // deleta a bebida referente ao id
        bebidaRepository.deleteById(id);        
    }
    
    @GetMapping(value="pesquisar/{nome}")
    public List<Bebida> getPesquisarPorNome(@PathVariable String nome) {
        List<Bebida> lista = bebidaRepository.findByNomeContainingIgnoreCaseOrderByPrecoDesc(nome);
        return lista;
    }
    
    @GetMapping(value="calcularPrecoMedioPorNome/{nome}")
    public Double getPrecoMedioPorNome(@PathVariable String nome) {
        Double precoMedio = bebidaRepository.calculaPrecoMedio(nome);
        return precoMedio;
    }
    
    
}