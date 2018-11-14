/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Davi
 */
@Entity
//@DiscriminatorValue("Professor PEB I")
public class ProfessorPebI extends Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String periodo;
    @OneToMany(mappedBy = "profPebI", cascade = CascadeType.MERGE)
    private List<Turma> turma;

    public ProfessorPebI() {
    }
    
    public List<Turma> getTurma() {
        return turma;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
