package br.edu.usj.sistemaxyz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login.html") 
        public String getLogin(@RequestParam String usuario, @RequestParam String senha) {
            if (usuario == "admin" && senha == "qwe123") {
                return "redirect:/login.html";
            } else {
                return "redirect:/";	
            }
            
    }
    
}