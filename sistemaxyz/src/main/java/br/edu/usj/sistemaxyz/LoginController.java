package br.edu.usj.sistemaxyz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @PostMapping(value = "/login") 
        public String getLogin(@RequestParam String usuario, @RequestParam String senha, RedirectAttributes redirectAttributes) {
            if (usuario.equals("admin") && senha.equals("qwe123")) {
                return "sistema";
            } else {
                String mensagem = "ERROOOOWWWW";
                redirectAttributes.addFlashAttribute("mensagem", mensagem);
                return "redirect:/";	
            }
                        
    }
    
}