package br.com.rodrigo.abreu.spock_test.entity;

import br.com.rodrigo.abreu.spock_test.enumeration.SexoEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String email;
    private SexoEnum sexo;
    private LocalDate dtNascimento;

}
