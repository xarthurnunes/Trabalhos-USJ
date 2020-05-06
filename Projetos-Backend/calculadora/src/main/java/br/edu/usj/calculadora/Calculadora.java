package br.edu.usj.calculadora;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    List<String> listaOperacoes = new ArrayList<>();

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String num1, @RequestParam String num2,
            @RequestParam String operador) {

            

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        String texto;
        String operacao = num1 + operador + num2 +"=" + resultado;
        switch (operador) {
            case "+":
                resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                listaOperacoes.add(operacao);
                modelAndView.addObject("mensagem", texto);
                modelAndView.addObject("historico", listaOperacoes);
                break;
            case "-":
                resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                listaOperacoes.add(operacao);
                modelAndView.addObject("mensagem", texto);
                modelAndView.addObject("historico", listaOperacoes);
                break;
            case "x":
                resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                listaOperacoes.add(operacao);
                modelAndView.addObject("mensagem", texto);
                modelAndView.addObject("historico", listaOperacoes);
                break;
            case "/":
                resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                listaOperacoes.add(operacao);
                modelAndView.addObject("mensagem", texto);
                modelAndView.addObject("historico", listaOperacoes);
                break;
                
        }

        
        return modelAndView;
    }

}