package br.edu.usj.contatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Contato {

    @Autowired
    ContatoRepository contatoRepository;

    @PostMapping(value="/cadastrar-contato")
    public ModelAndView postContato(@RequestParam String nome, @RequestParam String email, @RequestParam String telefone) {
        String mensagem;
        ModelAndView modelAndView = new ModelAndView("index");
        String nomeContato = nome;
        String emailContato = email;
        String telefoneContato = telefone;

        

        Contatos contato = new Contatos();

        mensagem = "O contato "+nomeContato +" foi cadastrado com sucesso!!!";
        
        contato.setNome(nomeContato);
        contato.setTelefone(telefoneContato);
        contato.setEmail(emailContato);

        contatoRepository.save(contato);

        modelAndView.addObject("mensagem", mensagem);
        modelAndView.addObject("historico", contatoRepository.findAll());
     
        
        return modelAndView;
    }
    

    
}