package br.edu.usj.lpii.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloWorld {

    @GetMapping(value="helloworld")
    public String getHelloWorld() {
        return "HelloWorld";
    }
    
}