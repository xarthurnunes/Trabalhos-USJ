package br.edu.usj.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscarCadastro {

    @Autowired
    CadastroRepository cadastroRepository;

    @PostMapping(value="/busca")
    ModelAndView postBuscar(@RequestParam String nome) {
    ModelAndView modelAndView = new ModelAndView("busca");
    modelAndView.addObject("busca", cadastroRepository.findByNome(nome));

    return modelAndView;

    }
    
}