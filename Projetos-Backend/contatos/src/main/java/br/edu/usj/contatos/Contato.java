package br.edu.usj.contatos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Contato {

    Historico historico = new Historico();

    @PostMapping(value="/cadastrar-contato")
    public ModelAndView postContato(@RequestParam String nome, @RequestParam String email, @RequestParam String telefone) {
        String contato;
        String mensagem;
        ModelAndView modelAndView = new ModelAndView("index");
        String nomeContato = nome;
        String emailContato = email;
        String telefoneContato = telefone;
        contato = "Nome: "+ nomeContato+" /Email:" +emailContato+" /Telefone:" + telefoneContato;
        mensagem = "O contato "+nomeContato +" foi cadastrado com sucesso!!!";
        historico.adicionar(contato);
        modelAndView.addObject("mensagem", mensagem);
        modelAndView.addObject("historico", historico.lerContato());
     
        
        return modelAndView;
    }
    

    
}