package br.edu.usj.lpii.helloname.helloname;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloName {
    @PostMapping(value="helloName")
    public ModelAndView postHelloName(@RequestParam String nome) {
        String mensagem = "Hello, " + nome + "!" ;
        
        ModelAndView modelAndView = new ModelAndView("helloname");
        modelAndView.addObject("mensagem", mensagem);
        
        return modelAndView;
    }
    

}