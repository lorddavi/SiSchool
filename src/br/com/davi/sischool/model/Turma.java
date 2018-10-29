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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Davi
 */

@Entity
public class Turma implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String turma;
    @Column
    private String letra;
    @Column
    private String periodo;
    @Column
    private int[][] cronograma =  new int[5][5];
    @Column
    private int vagas;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="escola_id")
    private Escola escola;
    @OneToMany(mappedBy = "serie", targetEntity = Aluno.class, fetch = FetchType.LAZY, 
            cascade = CascadeType.MERGE)
    private List<Aluno> alunos;
    @ManyToOne(targetEntity = ProfessorPebI.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ProfessorPebI profPebI;
    @ManyToMany(mappedBy = "turmas", targetEntity = ProfessorPebII.class, cascade = CascadeType.MERGE)
    private List<ProfessorPebII> profPebII;
    
    public Turma(){   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[][] getCronograma() {
        return cronograma;
    }

    public void setCronograma(int[][] cronograma) {
        this.cronograma = cronograma;
    }
    
    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public ProfessorPebI getProfPebI() {
        return profPebI;
    }

    public void setProfPebI(ProfessorPebI profPebI) {
        this.profPebI = profPebI;
    }

    public List<ProfessorPebII> getProfPebII() {
        return profPebII;
    }

    public void setProfPebII(List<ProfessorPebII> profPebII) {
        this.profPebII = profPebII;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return turma + " " + letra;
    }
  
}
