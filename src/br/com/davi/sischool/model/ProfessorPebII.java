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
import javax.persistence.ManyToMany;

/**
 *
 * @author Davi
 */
@Entity
//@DiscriminatorValue("Professor PEB II")
public class ProfessorPebII extends Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String especialidade;
    @Column
    private int aulasAtribuidas;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Turma> turmas;

    public ProfessorPebII() {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getAulasAtribuidas() {
        return aulasAtribuidas;
    }

    public void setAulasAtribuidas(int aulasAtribuidas) {
        this.aulasAtribuidas = aulasAtribuidas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
}
