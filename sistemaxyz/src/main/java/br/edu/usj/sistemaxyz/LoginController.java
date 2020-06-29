package br.edu.usj.sistemaxyz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping(value = "/login") 
        public String getLogin(@RequestParam String usuario, @RequestParam String senha) {
            return "login";
        //    if (usuario == "admin" && senha == "qwe123") {
        //        return "login";
        //    } else {
        //        return "index";	
        //    }
            
    }
    
}