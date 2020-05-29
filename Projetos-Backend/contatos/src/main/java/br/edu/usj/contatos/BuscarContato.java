package br.edu.usj.contatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscarContato {

    @Autowired
    ContatoRepository contatoRepository;

    @PostMapping(value="/buscar-contato")
    ModelAndView postBuscar(@RequestParam String nome) {
        ModelAndView modelAndView = new ModelAndView("buscar");

        modelAndView.addObject("buscar", contatoRepository.findByNome(nome));

        return modelAndView;
    }
    
    
}