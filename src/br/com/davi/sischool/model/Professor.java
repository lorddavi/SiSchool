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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Davi
 */
@Entity
public class Professor extends Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int pontos;
    @OneToMany(mappedBy = "professor", targetEntity = Certificado.class, fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL)
    private List<Certificado> certificados;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Escola> escola;    
    
    public Professor() {
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public List<Escola> getEscola() {
        return escola;
    }

    public void setEscola(List<Escola> escola) {
        this.escola = escola;
    }
    
}
