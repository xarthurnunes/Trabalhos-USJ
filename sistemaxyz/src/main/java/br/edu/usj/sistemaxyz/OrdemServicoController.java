package br.edu.usj.sistemaxyz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdemServicoController {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @GetMapping(value="/mostraros/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostraros");
        modelAndView.addObject("ordemservico", ordemServico);

        return modelAndView;
    }

    @PostMapping(value="/mostraros")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostraros");
        modelAndView.addObject("ordemservico", ordemServico);

        return modelAndView;
    }



    @GetMapping(value="/cadastraros")
    public ModelAndView getCadastrar() {
        //retorna o formulário para o usuário para preencher
        OrdemServico ordemServico = new OrdemServico();
        ModelAndView modelAndView = new ModelAndView("cadastraros");
        modelAndView.addObject("ordemservico", ordemServico);
        return modelAndView;
    }

    @PostMapping(value="/cadastraros")
    public ModelAndView postCadastrar(OrdemServico ordemServico) {
        OrdemServico ordemServicoSalva = ordemServicoRepository.save(ordemServico);
        return getMostrar(ordemServicoSalva.getId());
    }

    @GetMapping(value="/deletaros/{id}")
    public String getDeletar(@PathVariable Long id) {
        // deleta a bebida referente ao id
        ordemServicoRepository.deleteById(id);
        return "redirect:/buscaros";
    }

    @GetMapping(value="/editaros/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastraros");
        modelAndView.addObject("ordemservico", ordemServico);
        return modelAndView;
    }
    @GetMapping(value="/buscaros")
    public ModelAndView getListar() {
        List<OrdemServico> lista = ordemServicoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("buscaros");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
}