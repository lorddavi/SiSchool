/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Escola implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String endereco;
    @Column
    private String bairro;
    @OneToMany(targetEntity = Telefone.class, fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL)
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "escola", targetEntity = OutroCargo.class, fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL)
    private List<OutroCargo> funcOutroCargo;
    @ManyToMany(mappedBy = "escola", targetEntity = Professor.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Professor> professor;
    @OneToMany(mappedBy = "escola", targetEntity = Turma.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Turma> turmas;
    @OneToMany(mappedBy = "escola", targetEntity = Aluno.class, fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private List<Aluno> alunos;


    public Escola() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<OutroCargo> getFuncOutroCargo() {
        return funcOutroCargo;
    }

    public void setFuncOutroCargo(List<OutroCargo> funcOutroCargo) {
        this.funcOutroCargo = funcOutroCargo;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
