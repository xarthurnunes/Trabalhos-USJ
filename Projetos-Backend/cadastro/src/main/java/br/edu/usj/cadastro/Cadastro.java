package br.edu.usj.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Cadastro {

    @Autowired
    CadastroRepository cadastroRepository;

    @PostMapping(value = "/cadastrar")
    public ModelAndView postCadastrar(@RequestParam String nome, @RequestParam String cpf,
            @RequestParam String endereco, @RequestParam String complemento,
            @RequestParam String datanasc, @RequestParam String senha,
            @RequestParam String confSenha, @RequestParam String email) {

        
        String mensagem = "";
        //String nomeContato = nome, cpfUsuario = cpf, enderecoUsuario = endereco, complUsuario = complemento, aniversario = datanasc, senhaUsuario = senha, emailUsuario = email;
        ModelAndView modelAndView = new ModelAndView("index");
        Cadastros cadastros = new Cadastros();

        cadastros.setNome(nome);
        cadastros.setCpf(cpf);
        cadastros.setEndereco(endereco);
        cadastros.setComplemento(complemento);
        cadastros.setDatanasc(datanasc);
        cadastros.setSenha(senha);
        cadastros.setEmail(email);
        cadastroRepository.save(cadastros);

        mensagem = "O usuário " + nome + " foi cadastrado com sucesso!";

               
        modelAndView.addObject("mensagem", mensagem);

        return modelAndView;
    }
    @GetMapping(value="/deleta/{id}")
    public ModelAndView getDeleta(@PathVariable Long id) {
        cadastroRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("busca");
        modelAndView.addObject("busca", cadastroRepository.findAll());
        return modelAndView;
    }
}