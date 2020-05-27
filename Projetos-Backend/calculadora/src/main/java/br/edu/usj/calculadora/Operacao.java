package br.edu.usj.calculadora;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String operacao;


    
}