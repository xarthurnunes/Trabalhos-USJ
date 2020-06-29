package br.edu.usj.sistemaxyz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController {
    @PostMapping(value = "/contato")
    public String postContato() {
        return "contato";
    }
    @GetMapping(value = "/contato")
    public String getContato() {
        return "contato";
    }
}