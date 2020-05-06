package br.edu.usj.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    Historico historico = new Historico();

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String num1, @RequestParam String num2,
            @RequestParam String operador) {

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        String texto, operacao;

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

        }
        operacao = num1 + operador + num2 + "=" + resultado;
        texto = "O resultado é " + resultado;
        historico.adicionar(operacao);
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", historico.lerOperacao());

        return modelAndView;
    }

}