package br.edu.usj.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    @Autowired
    OperacaoRepository operacaoRepository;

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String num1, @RequestParam String num2,
            @RequestParam String operador) {

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        String texto, operacaoString;

        switch (operador) {
            case "+":
                resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case "-":
                resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "x":
                resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "/":
                resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
            
            default: resultado = 0.0;

               
        }
        
        operacaoString = num1 + operador + num2 + "=" + resultado;

        Operacao operacao = new Operacao();

        operacao.setOperacao(operacaoString);
        
        texto = "O resultado é " + resultado;

        operacaoRepository.save(operacao);
        
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", operacaoRepository.findAll());

        return modelAndView;
    }

}