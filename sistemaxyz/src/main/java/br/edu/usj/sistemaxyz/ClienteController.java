package br.edu.usj.sistemaxyz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {


    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value="/mostrarclientes/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrarclientes");
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @PostMapping(value="/mostrarclientes")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrarclientes");
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }



    @GetMapping(value="/cadastrarclientes")
    public ModelAndView getCadastrar() {
        //retorna o formulário para o usuário para preencher
        Cliente cliente = new Cliente();
        ModelAndView modelAndView = new ModelAndView("cadastrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping(value="/cadastrarclientes")
    public ModelAndView postCadastrar(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return getMostrar(clienteSalvo.getId());
    }

    @GetMapping(value="/deletarcliente/{id}")
    public String getDeletar(@PathVariable Long id) {
        // deleta a bebida referente ao id
        clienteRepository.deleteById(id);
        return "redirect:/buscarclientes";
    }

    @GetMapping(value="/editarcliente/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }
    @GetMapping(value="/buscarclientes")
    public ModelAndView getListar() {
        List<Cliente> lista = clienteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("buscarclientes");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    
}