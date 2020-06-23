package br.edu.usj.drinkstorebackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
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

    //@GetMapping(value="/cadastrar")
    //public ModelAndView getCadastrar() {
        //retorna o formulário para o usuário para preencher
    //    Bebida bebida = new Bebida();
    //    ModelAndView modelAndView = new ModelAndView("cadastrar");
    //   modelAndView.addObject("bebida", bebida);
    //    return modelAndView;
    //}
    
    @PostMapping(value="/cadastrar")
    public Bebida postCadastrar(Bebida bebida) {
        //recebe a bebida preenchida no formulário e grava no banco
        Bebida bebidaSalva = bebidaRepository.save(bebida);
        return bebidaSalva;
    }

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        // deleta a bebida referente ao id
        bebidaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public Bebida getEditar(@PathVariable Long id) {
        // retornar o formulário de cadastro com a a bebida "id" preenchida no form
        Bebida bebida = bebidaRepository.findById(id).get();
        return bebida;
    }
    
    
    
}