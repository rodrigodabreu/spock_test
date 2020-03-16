package br.com.rodrigo.abreu.spock_test.entity;

import br.com.rodrigo.abreu.spock_test.enumeration.SexoEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 1, max = 120)
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private SexoEnum sexo;

    @NotNull
    private LocalDate dtNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente that = (Cliente) o;

        return Objects.equals(this.dtNascimento, that.dtNascimento) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.sexo, that.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtNascimento, email, id, nome, sexo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("dtNascimento = " + dtNascimento)
                .add("email = " + email)
                .add("id = " + id)
                .add("nome = " + nome)
                .add("sexo = " + sexo)
                .toString();
    }
}
