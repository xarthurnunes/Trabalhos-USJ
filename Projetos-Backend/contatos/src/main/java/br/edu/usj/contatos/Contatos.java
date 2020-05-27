package br.edu.usj.contatos;

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
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String contato;

    
}