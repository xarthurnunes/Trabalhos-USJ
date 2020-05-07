package br.edu.usj.contatos;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    List<String> listaContato = new ArrayList<>();

    void adicionar(String contato) {
        listaContato.add(contato);
    }

    List<String> lerContato() {
        return listaContato;
    }
    

}