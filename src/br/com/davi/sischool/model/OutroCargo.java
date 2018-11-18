/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Davi
 */
@Entity
//@DiscriminatorValue("outrosCargos")
public class OutroCargo extends Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="escola_id")
    private Escola escola;

    public OutroCargo() {
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Escola getEscola() {
        return escola;
    }
    
    
}
