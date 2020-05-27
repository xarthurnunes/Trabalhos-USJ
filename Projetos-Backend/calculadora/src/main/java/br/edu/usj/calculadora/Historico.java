package br.edu.usj.calculadora;

import java.util.ArrayList;
import java.util.List;


public class Historico {

    List<Operacao> listaOperacoes = new ArrayList<>();

    void adicionar(Operacao operacao) {
        listaOperacoes.add(operacao);
    }

    List<Operacao> lerOperacao() {
        return listaOperacoes;
    }
    
}