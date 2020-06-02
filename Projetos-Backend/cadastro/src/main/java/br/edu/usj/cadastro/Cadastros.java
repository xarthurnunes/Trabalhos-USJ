package br.edu.usj.cadastro;

import javax.persistence.Column;
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
public class Cadastros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
   

    @Column(name = "nome")
    String nome;
    @Column(name = "cpf")
    String cpf;
    @Column(name = "endereco")
    String endereco;
    @Column(name = "complemento")
    String complemento;
    @Column(name = "aniversario")
    String datanasc;
    @Column(name = "senha")
    String senha;
    @Column(name = "email")
    String email;

       
}