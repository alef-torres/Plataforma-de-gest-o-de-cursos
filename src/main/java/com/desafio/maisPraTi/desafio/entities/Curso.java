package com.desafio.maisPraTi.desafio.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataDeConclusao;

    public Curso() {
    }

    public Curso(Long id, String nome, String dataDeConclusao) {
        this.nome = nome;
        this.dataDeConclusao = dataDeConclusao;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(String dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
