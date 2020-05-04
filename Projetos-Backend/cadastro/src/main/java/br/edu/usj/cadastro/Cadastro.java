package br.edu.usj.cadastro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Cadastro {

    @PostMapping(value = "/cadastrar")
    public ModelAndView postCadastrar(@RequestParam String nome, @RequestParam String cpf,
            @RequestParam String endereco, @RequestParam String complemento,
            @RequestParam String datanasc, @RequestParam String senha,
            @RequestParam String confSenha, @RequestParam String email) {

        final ModelAndView modelAndView = new ModelAndView("index");
        String texto;
        String nomeUsuario = nome;
        String cpfUsuario = cpf;
        String endUsuario = endereco;
        String complUsuario = complemento;
        String aniversario = datanasc;
        String senhaUsuario = senha;
        String emailUsuario = email;

        texto = "Usuário cadastrado com sucesso com os parâmetros: \nNome:" + nomeUsuario +"\nCPF: "+cpfUsuario+"\nEndereço: "+endUsuario
        + "\nComplemento: "+complUsuario+"\nData de Nascimento: "+aniversario+"\nSenha: "+senhaUsuario+"\nE-mail: "+emailUsuario;
        modelAndView.addObject("mensagem", texto);

        return modelAndView;
    }
}