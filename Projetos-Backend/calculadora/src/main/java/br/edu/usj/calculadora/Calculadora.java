package br.edu.usj.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String num1, @RequestParam String num2,
            @RequestParam String operador) {

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        String texto;
        switch (operador) {
            case "+":
                resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                modelAndView.addObject("mensagem", texto);
                break;
            case "-":
                resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                modelAndView.addObject("mensagem", texto);
                break;
            case "x":
                resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                modelAndView.addObject("mensagem", texto);
                break;
            case "/":
                resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                texto = "O resultado é " + resultado;
                modelAndView.addObject("mensagem", texto);
                break;
        }

        
        return modelAndView;
    }

}